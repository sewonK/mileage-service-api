package triple.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import triple.backend.dto.EventResponse;
import triple.backend.dto.PointResponse;
import triple.backend.service.ResponseService;
import triple.backend.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final ResponseService responseServiceImpl;
    private final UserService userServiceImpl;

    @GetMapping("/point/{userId}")
    public EventResponse<PointResponse> getUserPoint(@PathVariable String userId){
        return responseServiceImpl.getEventResult(userServiceImpl.getUserPoint(userId));
    }
}
