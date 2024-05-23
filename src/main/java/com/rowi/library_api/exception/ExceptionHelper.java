package com.rowi.library_api.exception;

import com.rowi.library_api.dto.CommonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@Log4j2
public class ExceptionHelper extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoRecodeFoundCustomeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<Object> handleInvalidInputException(NoRecodeFoundCustomeException ex) {
        log.error("NoRecodeFoundException: {}", ex.getMessage());
        return CommonResponse.builder()
                .message(ex.getMessage())
                .build();
    }

 @ExceptionHandler(CustomeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<Object> handleInvalidInputException(CustomeException ex) {
        log.error("NoRecodeFoundException: {}", ex.getMessage());
        return CommonResponse.builder()
                .message(ex.getMessage())
                .build();
    }

}
