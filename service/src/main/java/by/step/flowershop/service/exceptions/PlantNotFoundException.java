package by.step.flowershop.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlantNotFoundException extends Exception {

    private String message;
    private Long id;

    public PlantNotFoundException(String message) {

    }
}
