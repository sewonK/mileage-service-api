package triple.backend.service;

import org.springframework.stereotype.Service;
import triple.backend.dto.EventResponse;
import triple.backend.dto.Response;
import triple.backend.enums.StatusCode;

@Service
public class ResponseServiceImpl implements ResponseService{
    @Override
    public <T> EventResponse<T> getEventResult(T data) {
        EventResponse<T> response = new EventResponse<>();
        response.setData(data);
        setSuccess(response);
        return response;
    }

    private void setSuccess(Response response) {
        response.setStatus(StatusCode.SUCCESS.getStatus());
        response.setCode(StatusCode.SUCCESS.getCode());
        response.setMessage(StatusCode.SUCCESS.getMessage());
    }
}
