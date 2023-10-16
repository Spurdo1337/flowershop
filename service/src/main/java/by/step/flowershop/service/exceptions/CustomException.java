package by.step.flowershop.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class CustomException extends Exception {

    private String message;
    private String stamp;
}
