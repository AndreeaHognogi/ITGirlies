package ro.ubbcluj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.core.service.UserService;
import ro.ubbcluj.web.converter.UserConverter;
import ro.ubbcluj.web.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    UserConverter userConverter;

    @RequestMapping(value= "/users", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        log.trace("getUsers");
        List<User> users = userService.findAll();
        log.trace("getUsers: users: {}", users);
        return  new ArrayList<>(userConverter.convertModelsToDtos(users));
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public UserDto getUserById(@PathVariable("userId") final Long userId) {
        log.trace("getUserById");
        User user = userService.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        log.trace("getUserById: user: {}", user);
        return userConverter.convertModelToDto(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public UserDto createUser(@RequestBody final UserDto userDto) {
        log.trace("createUser: userDto: {}", userDto);
        UserDto resultUserDto = userConverter.convertModelToDto(
                userService.addUser(userConverter.convertDtoToModel(userDto)));
        return resultUserDto;
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public UserDto updateUser(
            @PathVariable("userId") final Long userId,
            @RequestBody final UserDto userDto) {
        log.trace("updateUser: userDto: {}", userDto);
        User tempUser = new User();
        tempUser.setId(userId);
        tempUser.setFirstname(userDto.getFirstname());
        tempUser.setLastname(userDto.getLastname());
        tempUser.setUsername(userDto.getUsername());
        tempUser.setPassword(userDto.getPassword());
        tempUser.setEmail(userDto.getEmail());
        tempUser.setPhone(userDto.getPhone());
        tempUser.setRole(userDto.getRole());
        tempUser.setValidated(userDto.isValidated());
        return userConverter.convertModelToDto(
                userService.updateUser(tempUser));
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("userId") final Long userId) {
        log.warn("deleteUser: userId: {}", userId);
        try{
            userService.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Error error) {
            log.warn("Something went wrong while deleting user: {}", error);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
