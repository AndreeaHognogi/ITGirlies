package ro.ubbcluj.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.core.service.UserService;

import java.util.Optional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findAll()
                .stream()
                .filter(u -> u.getEmail().equals(username))
                .findFirst();

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        User user = optionalUser.get();

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(new SimpleGrantedAuthority(user.getRole().name()))
                .accountLocked(!user.getValidated())
                .build();
    }
}
