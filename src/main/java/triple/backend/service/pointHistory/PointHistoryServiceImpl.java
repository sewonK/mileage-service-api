package triple.backend.service.pointHistory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.EventRequest;
import triple.backend.entity.PointHistory;
import triple.backend.entity.Review;
import triple.backend.enums.PointDetails;
import triple.backend.enums.PointType;
import triple.backend.repository.PointHistoryRepository;
import triple.backend.service.review.ReviewService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PointHistoryServiceImpl implements PointHistoryService {
    private final PointHistoryRepository pointHistoryRepository;
    private final ReviewService reviewServiceImpl;

    @Override
    public int savePointHistory(EventRequest eventRequest, PointType pointType, PointDetails pointDetails) {
        Review review = reviewServiceImpl.findById(eventRequest.getReviewId());
        PointHistory pointHistory = new PointHistory();
        pointHistory.setReview(review);
        pointHistory.setPointType(pointType);
        pointHistory.setPointDetails(pointDetails);
        pointHistory.setPoint(pointType.getValue() * pointDetails.getPoint());
        pointHistoryRepository.save(pointHistory);
        return pointHistory.getPoint();
    }

    @Override
    public Long getPoint(EventRequest eventRequest, PointDetails pointDetails) {
        return pointHistoryRepository.getPointByReviewAndPointDetails(UUID.fromString(eventRequest.getReviewId()), pointDetails);
    }
}
