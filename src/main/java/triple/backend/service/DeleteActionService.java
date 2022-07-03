package triple.backend.service;

import org.springframework.stereotype.Service;
import triple.backend.dto.EventRequest;
import triple.backend.enums.PointDetails;
import triple.backend.enums.PointType;

@Service
public class DeleteActionService implements ActionService {
    private final PointHistoryService pointHistoryServiceImpl;
    private final ReviewService reviewServiceImpl;

    public DeleteActionService(PointHistoryService pointHistoryServiceImpl, ReviewService reviewServiceImpl) {
        this.pointHistoryServiceImpl = pointHistoryServiceImpl;
        this.reviewServiceImpl = reviewServiceImpl;
    }
    @Override
    public int calculatePoints(EventRequest eventRequest) {
        int point = 0;
        for (PointDetails pointDetail : PointDetails.values()) {
            if(hasReview(eventRequest, pointDetail)) {
                point += pointHistoryServiceImpl.savePointHistory(eventRequest, PointType.MINUS, pointDetail);
            }
        }
        return point;
    }

    @Override
    public boolean checkReviewType(EventRequest eventRequest, PointDetails pointDetails) {
        if(pointDetails == PointDetails.TEXT) return eventRequest.getContent().length() > 0;
        if(pointDetails == PointDetails.PHOTO) return eventRequest.getAttachedPhotoIds().size() > 0;
        if(pointDetails == PointDetails.BONUS) return reviewServiceImpl.isFirstReview(eventRequest);
        return false;
    }

    public boolean hasReview(EventRequest eventRequest, PointDetails pointDetails) {
        return pointHistoryServiceImpl.getPoint(eventRequest, pointDetails) > 0;
    }
}
