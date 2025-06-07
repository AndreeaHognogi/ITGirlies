package ro.ubbcluj.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.core.model.Cerere;
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
        Cerere cerere = new Cerere();
        cerere.setId(1L);
        User user = new User();
        user.setUsermane(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setRole(userDto.getRole());
        user.setValidated(false);
        return user;
    }

    @Override
    public UserDto convertModelToDto(User user) {
        UserDto userDto = UserDto.builder()
                .username(user.getUsermane())
                .password(user.getPassword())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole())
                .validate(false)
                .build();
        userDto.setId(user.getId());
        return userDto;
    }
}
