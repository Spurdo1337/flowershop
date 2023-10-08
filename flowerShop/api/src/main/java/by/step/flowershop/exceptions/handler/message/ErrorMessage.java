package by.step.flowershop.exceptions.handler.message;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Builder
@Data
public class ErrorMessage {
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String stamp;
}
