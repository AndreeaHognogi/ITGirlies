package ro.ubbcluj.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthLoginRequestDto extends BaseDto {
    private String email;
    private String password;

    // Getters & setters
}
