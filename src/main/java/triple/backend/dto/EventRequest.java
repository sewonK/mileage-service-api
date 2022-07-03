package triple.backend.dto;

import lombok.Getter;
import triple.backend.enums.ActionType;

import java.util.List;

@Getter
public class EventRequest {
    private String type;
    private ActionType action;
    private String reviewId;
    private String content;
    private List<String> attachedPhotoIds;
    private String userId;
    private String placeId;
}
