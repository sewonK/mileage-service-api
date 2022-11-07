package triple.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import triple.backend.dto.EventRequest;
import triple.backend.dto.EventResponse;
import triple.backend.dto.PointResponse;
import triple.backend.service.point.PointService;
import triple.backend.service.response.ResponseService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {
    private final ResponseService responseServiceImpl;
    private final PointService pointServiceImpl;

    @PostMapping("")
    public EventResponse<PointResponse> handleEvents(@RequestBody EventRequest eventRequest){
        return responseServiceImpl.getEventResult(pointServiceImpl.handleEvent(eventRequest));
    }
}
