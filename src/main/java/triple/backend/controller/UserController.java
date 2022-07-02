package triple.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import triple.backend.dto.EventRequest;
import triple.backend.dto.EventResponse;
import triple.backend.dto.UserResponse;
import triple.backend.service.ResponseService;
import triple.backend.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final ResponseService responseServiceImpl;
    private final UserService userServiceImpl;

    @PostMapping("")
    public EventResponse<UserResponse> saveUser(@RequestBody EventRequest eventRequest){
        return responseServiceImpl.getEventResult(userServiceImpl.saveUserById(eventRequest.getUserId()));
    }
}
