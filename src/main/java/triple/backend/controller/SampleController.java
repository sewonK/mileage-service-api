package triple.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import triple.backend.dto.EventRequest;
import triple.backend.dto.EventResponse;
import triple.backend.dto.PointResponse;
import triple.backend.enums.ActionType;
import triple.backend.service.ResponseService;
import triple.backend.service.ReviewService;
import triple.backend.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {
    private final UserService userServiceImpl;
    private final ResponseService responseServiceImpl;
    private final ReviewService reviewServiceImpl;

    @PostMapping("")
    public EventResponse<PointResponse> handleEvents(@RequestBody EventRequest eventRequest){
        PointResponse pointResponse = userServiceImpl.saveUserById(eventRequest.getUserId());
        if(eventRequest.getAction() == ActionType.DELETE)
            reviewServiceImpl.deleteReview(eventRequest);
        else reviewServiceImpl.saveReview(eventRequest);
        return responseServiceImpl.getEventResult(pointResponse);
    }
}
