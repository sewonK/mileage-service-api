package triple.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.EventRequest;
import triple.backend.entity.PointHistory;
import triple.backend.entity.Review;
import triple.backend.entity.User;
import triple.backend.enums.PointDetails;
import triple.backend.enums.PointType;
import triple.backend.repository.PointHistoryRepository;

@Service
@RequiredArgsConstructor
public class PointHistoryServiceImpl implements PointHistoryService {
    private final PointHistoryRepository pointHistoryRepository;
    private final ReviewService reviewServiceImpl;
    private final UserService userServiceImpl;

    @Override
    public int savePointHistory(EventRequest eventRequest, PointType pointType, PointDetails pointDetails) {
        Review review = reviewServiceImpl.findById(eventRequest.getReviewId());
        User user = userServiceImpl.findById(eventRequest.getUserId());
        PointHistory pointHistory = new PointHistory();
        pointHistory.setReview(review);
        pointHistory.setUser(user);
        pointHistory.setPointType(pointType);
        pointHistory.setPointDetails(pointDetails);
        pointHistory.setPoint(pointType.getValue() * pointDetails.getPoint());
        pointHistoryRepository.save(pointHistory);
        return pointHistory.getPoint();
    }

    @Override
    public int getPoint(EventRequest eventRequest, PointDetails pointDetails) {
        Review review = reviewServiceImpl.findById(eventRequest.getReviewId());
        return pointHistoryRepository.getPointByReviewAndPointDetails(review, pointDetails).getPoint();
    }
}
