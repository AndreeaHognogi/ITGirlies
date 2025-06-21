package ro.ubbcluj.web.controller;

import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.core.service.UserService;
import ro.ubbcluj.web.config.jwt.JWTConfig;
import ro.ubbcluj.web.dto.AuthLoginRequestDto;
import ro.ubbcluj.web.dto.UserDto;
import ro.ubbcluj.web.converter.UserConverter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
@Autowired
    private JWTConfig jwtConfig;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthLoginRequestDto authRequest) {
        log.trace("login: {} {} {}", authRequest.getEmail(), authRequest.getPassword(), passwordEncoder.encode(authRequest.getPassword()));

        Optional<User> userOpt = userService.findAll().stream()
                .filter(u -> u.getEmail().equals(authRequest.getEmail()) &&
                        passwordEncoder.matches(authRequest.getPassword(), u.getPassword()))
                .findFirst();

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            String jwt = Jwts.builder()
                    .setSubject(user.getEmail())
                    .claim("role", user.getRole())
                    .claim("Firstname", user.getFirstname())
                    .claim("Lastname", user.getLastname())
                    .claim("validated", user.getValidated())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpiration()))
                    .signWith(jwtConfig.getSecretKey())
                    .compact();

            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);

            if (user.getValidated() == false) {
                log.info("Userul {} nu are dreptul sa se logheze, nu e inca validat!", user.getEmail());
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User has to be validated first by an admin!");
            }

            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        log.trace("register: {}", userDto.getEmail());

//        User user = userConverter.convertDtoToModel(userDto);
//        user.setValidated(false);
//
//        User created = userService.addUser(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(userConverter.convertModelToDto(created));

        Optional<User> existingUser = userService.findAll().stream()
                .filter(u -> u.getEmail().equals(userDto.getEmail()))
                .findFirst();

        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already in use");
        }

        User user = userConverter.convertDtoToModel(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setValidated(false); // Implicit: așteaptă validarea de la un admin

        User savedUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userConverter.convertModelToDto(savedUser));
    }
}
