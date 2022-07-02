package triple.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    public int status;
    public String code;
    public String message;
}
