package triple.backend.service.response;

import triple.backend.dto.EventResponse;

public interface ResponseService {
    <T> EventResponse<T> getEventResult(T data);
}
