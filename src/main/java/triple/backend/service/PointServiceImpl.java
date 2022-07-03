package triple.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.EventRequest;
import triple.backend.dto.PointResponse;
import triple.backend.enums.ActionType;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService{
    private final ActionFactory actionFactoryImpl;
    private final UserService userServiceImpl;

    @Override
    public PointResponse handleEvent(EventRequest eventRequest) {
        ActionType actionType = eventRequest.getAction();
        ActionService actionService = actionFactoryImpl.getAction(actionType);
        //1. 액션 타입에 따라 포인트 계산, 동시에 이력 쌓기
        int diffPoint = actionService.calculatePoints(eventRequest);
        //2. 유저 보유 포인트 갱신
        int point = userServiceImpl.updatePoints(eventRequest.getUserId(), diffPoint);

        return new PointResponse(eventRequest.getUserId(), point);
    }
}
