package triple.backend.service.action;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.EventRequest;
import triple.backend.enums.PointDetails;
import triple.backend.enums.PointType;
import triple.backend.service.pointHistory.PointHistoryService;

@Service
@RequiredArgsConstructor
public class DeleteActionService implements ActionService {
    private final PointHistoryService pointHistoryServiceImpl;

    @Override
    public int calculatePoints(EventRequest eventRequest) {
        int point = 0;
        for (PointDetails pointDetail : PointDetails.values()) {
            if(checkBeforeReview(eventRequest, pointDetail)) {
                point += pointHistoryServiceImpl.savePointHistory(eventRequest, PointType.MINUS, pointDetail);
            }
        }
        return point;
    }

    public boolean checkBeforeReview(EventRequest eventRequest, PointDetails pointDetails) {
        return pointHistoryServiceImpl.getPoint(eventRequest, pointDetails) > 0;
    }
}
