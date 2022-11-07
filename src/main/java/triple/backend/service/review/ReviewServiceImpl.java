package triple.backend.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.EventRequest;
import triple.backend.entity.Review;
import triple.backend.exception.ReviewNotFoundException;
import triple.backend.repository.ReviewRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;

    @Override
    public Review findById(String reviewId) {
        return reviewRepository.findById(UUID.fromString(reviewId)).orElseThrow(ReviewNotFoundException::new);
    }

    @Override
    public boolean isFirstReview(EventRequest eventRequest) {
        Optional<Review> review = reviewRepository.findFirstByPlaceIdOrderByCreatedDate(UUID.fromString(eventRequest.getPlaceId()));
        return review.map(r -> r.getReviewId().equals(UUID.fromString(eventRequest.getReviewId()))).orElse(false);
    }
}
