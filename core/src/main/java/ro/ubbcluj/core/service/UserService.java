package ro.ubbcluj.core.service;

import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    User addUser (User user);
    User updateUser (User user);
    void deleteById(Long id);
    boolean resetPassword(String email, String newPassword);
    Optional<User> findByEmail(String email);
    User findUserByEmail(String email);
    User findByUsername(String username);
}
