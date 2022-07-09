package triple.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {
    SUCCESS(200, "SUCCESS", "OK"),
    NOT_FOUND(404,"COMMON-ERR-404","PAGE NOT FOUND"),
    INTER_SERVER_ERROR(500,"COMMON-ERR-500","INTER SERVER ERROR"),
    USER_NOT_FOUND(400,"USER-ERR-400","USER NOT FOUND"),
    REVIEW_NOT_FOUND(400,"REVIEW-ERR-400","REVIEW NOT FOUND"),
    ACTION_TYPE_ERROR(400, "ACTION-ERR-400", "ACTION TYPE ERROR"),
    ;

    private int status;
    private String code;
    private String message;
}
