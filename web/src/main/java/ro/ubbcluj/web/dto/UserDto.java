package ro.ubbcluj.web.dto;

import lombok.*;
import ro.ubbcluj.core.model.Role;
import ro.ubbcluj.core.model.User;

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
    private boolean validate;
    private Role role;


}
