package triple.backend.service;

import triple.backend.dto.EventResponse;
import triple.backend.dto.Response;
import triple.backend.enums.StatusCode;

public class ResponseServiceImpl implements ResponseService{
    @Override
    public <T> EventResponse<T> getEventResult(T data) {
        EventResponse<T> result = new EventResponse<>();
        result.setData(data);
        setSuccess(result);
        return result;
    }

    private void setSuccess(Response response) {
        response.setStatus(StatusCode.SUCCESS.getStatus());
        response.setCode(StatusCode.SUCCESS.getCode());
        response.setMessage(StatusCode.SUCCESS.getMessage());
    }
}
