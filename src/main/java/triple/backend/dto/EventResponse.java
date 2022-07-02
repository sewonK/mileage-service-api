package triple.backend.dto;

import lombok.Setter;

@Setter
public class EventResponse<T> extends Response {
    private T data;
}
