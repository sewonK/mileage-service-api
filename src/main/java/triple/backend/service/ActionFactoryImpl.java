package triple.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.enums.ActionType;
import triple.backend.exception.ActionTypeErrorException;

@Service
@RequiredArgsConstructor
public class ActionFactoryImpl implements ActionFactory{
    private final ReviewService reviewServiceImpl;
    @Override
    public Action getAction(ActionType actionType) {
        if(actionType == ActionType.ADD){
            return new AddAction(reviewServiceImpl);
        }
        else if(actionType == ActionType.MOD){
            return new ModAction(reviewServiceImpl);
        }
        else if(actionType == ActionType.DELETE){
            return new DeleteAction(reviewServiceImpl);
        } else {
            throw new ActionTypeErrorException();
        }
    }
}
