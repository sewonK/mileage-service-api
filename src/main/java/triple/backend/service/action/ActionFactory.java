package triple.backend.service.action;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.enums.ActionType;
import triple.backend.exception.ActionTypeErrorException;
import triple.backend.service.pointHistory.PointHistoryService;
import triple.backend.service.review.ReviewService;

@Service
@RequiredArgsConstructor
public class ActionFactory {
    private final PointHistoryService pointHistoryServiceImpl;
    private final ReviewService reviewServiceImpl;
    public ActionService getActionService(ActionType actionType) {
        if(actionType == ActionType.ADD){
            return new AddActionService(pointHistoryServiceImpl, reviewServiceImpl);
        }
        else if(actionType == ActionType.MOD){
            return new ModActionService(pointHistoryServiceImpl, reviewServiceImpl);
        }
        else if(actionType == ActionType.DELETE){
            return new DeleteActionService(pointHistoryServiceImpl);
        } else {
            throw new ActionTypeErrorException();
        }
    }
}
