package ua.com.foxminded.quickpoll.dto.error;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ValidationError {
    private String code;
    private String message;
}
