package triple.backend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import triple.backend.dto.ErrorResponse;
import triple.backend.enums.StatusCode;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e){
        log.error("handleUserNotFoundException",e);
        ErrorResponse response = new ErrorResponse(StatusCode.USER_NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.valueOf(StatusCode.USER_NOT_FOUND.getStatus()));
    }

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleReviewNotFoundException(ReviewNotFoundException e){
        log.error("handleReviewNotFoundException",e);
        ErrorResponse response = new ErrorResponse(StatusCode.REVIEW_NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.valueOf(StatusCode.REVIEW_NOT_FOUND.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e){
        log.error("handleException",e);
        ErrorResponse response = new ErrorResponse(StatusCode.INTER_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
