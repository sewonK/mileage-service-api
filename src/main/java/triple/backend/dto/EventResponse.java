package triple.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventResponse<T> extends Response {
    private T data;
}
