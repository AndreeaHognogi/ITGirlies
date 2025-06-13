package ro.ubbcluj.web.dto;

import lombok.*;
import ro.ubbcluj.core.model.Role;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDto extends BaseDto{
    private String username;
    private String password;
    private String email;
    private String phone;
    private String firstname;
    private String lastname;
    private boolean validated;
    private Role role;
}
