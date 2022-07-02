package triple.backend.dto;

import lombok.Getter;
import triple.backend.entity.Review;
import triple.backend.enums.Action;

import java.util.List;
import java.util.UUID;

@Getter
public class EventRequest {
    private String type;
    private Action action;
    private String reviewId;
    private String content;
    private List<String> attachedPhotoIds;
    private String userId;
    private String placeId;
}
