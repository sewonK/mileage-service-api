package triple.backend.service.point;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.EventRequest;
import triple.backend.dto.PointResponse;
import triple.backend.service.action.ActionFactory;
import triple.backend.service.action.ActionService;
import triple.backend.service.user.UserService;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService{
    private final ActionFactory actionFactory;
    private final UserService userServiceImpl;

    @Override
    public PointResponse handleEvent(EventRequest eventRequest) {
        ActionService actionService = actionFactory.getActionService(eventRequest.getAction());
        //1. 액션 타입에 따라 포인트 계산, 동시에 이력 쌓기
        int diffPoint = actionService.calculatePoints(eventRequest);
        //2. 유저 보유 포인트 갱신
        int point = userServiceImpl.updatePoints(eventRequest.getUserId(), diffPoint);
        return new PointResponse(eventRequest.getUserId(), point);
    }
}
