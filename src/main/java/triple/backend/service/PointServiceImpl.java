package triple.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.EventRequest;
import triple.backend.dto.PointResponse;
import triple.backend.entity.User;
import triple.backend.enums.ActionType;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService{
    private final ActionFactory actionFactoryImpl;
    private final UserService userServiceImpl;

    @Override
    public PointResponse handleEvent(EventRequest eventRequest) {
        ActionType actionType = eventRequest.getAction();
        Action action = actionFactoryImpl.getAction(actionType);
        //1. 액션 타입에 따라 포인트 계산, 동시에 이력 쌓기
        int diffPoint = action.calculatePoints(eventRequest);
        //2. 유저 보유 포인트 갱신
        int point = userServiceImpl.updatePoints(eventRequest.getUserId(), diffPoint);
        //3. 리뷰 반영(CUD)
        action.Do(eventRequest);

        return new PointResponse(eventRequest.getUserId(), point);
    }
}
