package triple.backend.dto;

import triple.backend.enums.StatusCode;

public class ErrorResponse extends Response{
    public ErrorResponse(StatusCode statusCode){
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
        this.code = statusCode.getCode();
    }
}
