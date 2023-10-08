package by.step.flowershop.exceptions.handler;

import by.step.flowershop.exceptions.handler.message.ErrorMessage;
import by.step.flowershop.service.exceptions.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;


@RestControllerAdvice
public class CustomExceptionAdvice {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorMessage handleValidationException(CustomException customException) {
        return ErrorMessage.builder()
                .message(customException.getMessage())
                .status(NO_CONTENT)
                .stamp(customException.getStamp())
                .timestamp(now())
                .build();
    }

}
