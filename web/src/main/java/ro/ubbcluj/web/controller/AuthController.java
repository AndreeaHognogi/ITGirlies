package ro.ubbcluj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.core.service.UserService;
import ro.ubbcluj.core.service.impl.CustomUserDetailsService;
import ro.ubbcluj.web.config.JwtService;
import ro.ubbcluj.web.converter.UserConverter;
import ro.ubbcluj.web.dto.AuthLoginRequestDto;
import ro.ubbcluj.web.dto.ResetPasswordDto;
import ro.ubbcluj.web.dto.UserDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @Autowired
    @Qualifier("customUserDetailsService")
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthLoginRequestDto authRequest) {
        log.trace("login: {} {} {}", authRequest.getEmail(), authRequest.getPassword(), passwordEncoder.encode(authRequest.getPassword()));

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        }catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credentiale invalide");
        }

//        Optional<User> userOpt = userService.findAll().stream()
//                .filter(u -> u.getEmail().equals(authRequest.getEmail()) &&
//                        passwordEncoder.matches(authRequest.getPassword(), u.getPassword()))
//                .findFirst();

        Optional<User> userOpt = userService.findByEmail(authRequest.getEmail());
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            String jwtToken = jwtService.generateToken(user);
            Map<String, String> response = new HashMap<>();
            response.put("token", jwtToken);

            if (user.getValidated() == false) {
                log.info("Userul {} nu are dreptul sa se logheze, nu e inca validat!", user.getEmail());
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User has to be validated first by an admin!");
            }
            return ResponseEntity.ok().body(response);

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credentiale invalide");
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

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordDto resetDto) {
        log.trace("resetPassword: {}", resetDto.getEmail());

        Map<String, String> response = new HashMap<>();

        boolean result = userService.resetPassword(resetDto.getEmail(), resetDto.getNewPassword());

        if (result) {
            response.put("message", "Parola a fost resetată cu succes.");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Emailul nu a fost găsit.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
