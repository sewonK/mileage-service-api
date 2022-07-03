package triple.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.EventRequest;
import triple.backend.entity.Photo;
import triple.backend.entity.Review;
import triple.backend.repository.PhotoRepository;
import triple.backend.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final PhotoRepository photoRepository;
    private final UserServiceImpl userServiceImpl;

    @Override
    public Review findById(String reviewId) {
        return reviewRepository.findById(UUID.fromString(reviewId)).orElseGet(Review::new);
    }

    @Override
    public boolean isFirstReview(EventRequest eventRequest) {
        Review review = reviewRepository.findFirstByPlaceIdOrderByCreatedDate(UUID.fromString(eventRequest.getPlaceId()));
        return review.getReviewId().equals(UUID.fromString(eventRequest.getReviewId()));
    }

    @Override
    public void saveReview(EventRequest eventRequest) {
        Review review = findById(eventRequest.getReviewId());
        review.setReviewId(UUID.fromString(eventRequest.getReviewId()));
        review.setUser(userServiceImpl.findById(eventRequest.getUserId()));
        review.setContent(eventRequest.getContent());
        review.setPlaceId(UUID.fromString(eventRequest.getPlaceId()));
        reviewRepository.save(review);

        List<Photo> photoList = new ArrayList<>();
        for(String photoId: eventRequest.getAttachedPhotoIds()){
            Photo photo = Photo.builder().photoId(UUID.fromString(photoId)).review(review).build();
            photoRepository.save(photo);
            photoList.add(photo);
        }
        review.setAttachedPhotoIds(photoList);
    }

    @Override
    public void deleteReview(EventRequest eventRequest) {
        Review review = findById(eventRequest.getReviewId());
        reviewRepository.delete(review);
    }
}
