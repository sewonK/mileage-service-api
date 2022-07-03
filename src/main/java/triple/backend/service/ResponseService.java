package triple.backend.service;

import triple.backend.dto.EventResponse;

public interface ResponseService {
    <T> EventResponse<T> getEventResult(T data);
}
