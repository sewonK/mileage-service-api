package triple.backend.dto;

import lombok.Setter;

@Setter
public class Response {
    public int status;
    public String code;
    public String message;
}
