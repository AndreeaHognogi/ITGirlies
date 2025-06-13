package ro.ubbcluj.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.web.dto.UserDto;

@Component
public class UserConverter extends AbstractConverterBaseEntityConverter<User, UserDto> {

    private static final Logger log = LoggerFactory.getLogger(UserConverter.class);
    private final CerereConverter cerereConverter;

    @Autowired
    public UserConverter(CerereConverter cerereConverter) {
        this.cerereConverter = cerereConverter;
    }
    @Override
    public User convertDtoToModel(UserDto userDto) {
        User user = new User();
        user.setLastname(userDto.getLastname());
        user.setFirstname(userDto.getFirstname());
        user.setUsermane(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setRole(userDto.getRole());
        user.setValidated(userDto.isValidated());
        return user;
    }

    @Override
    public UserDto convertModelToDto(User user) {
        UserDto userDto = UserDto.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsermane())
                .password(user.getPassword())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole())
                .validated(user.getValidated())
                .build();
        userDto.setId(user.getId());
        return userDto;
    }
}
