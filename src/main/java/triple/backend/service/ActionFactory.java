package triple.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.enums.ActionType;
import triple.backend.exception.ActionTypeErrorException;

@Service
@RequiredArgsConstructor
public class ActionFactory {
    private final PointHistoryService pointHistoryServiceImpl;
    private final ReviewService reviewServiceImpl;
    public ActionService getAction(ActionType actionType) {
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
