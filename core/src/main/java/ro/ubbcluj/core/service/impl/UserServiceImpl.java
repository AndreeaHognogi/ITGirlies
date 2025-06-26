package ro.ubbcluj.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.core.repository.UserRepository;
import ro.ubbcluj.core.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        log.trace("findAllUser--- method called");
        List<User> result = userRepository.findAll();
        log.trace("findAllUser --- method completed; result={}", result);
        return result;
    }

    @Override
    public Optional<User> findById(Long id) {
        log.info("findById --- method called; user={}", id);
        Optional<User> result = userRepository.findById(id);
        log.info("findById --- method completed; result={}", result);
        return result;
    }

    @Transactional
    @Override
    public User addUser(User user) {
        log.trace("addUser --- method called; user={}", user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result = userRepository.save(user);
        log.trace("addUser --- method completed; result={}", result);
        return result;
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        log.trace("updateUser --- method called; user={}", user);
        User updateUser = userRepository.findById(user.getId()).orElse(new User());
        log.trace("updatedUser - {}", updateUser);
        updateUser.setFirstname(user.getFirstname());
        updateUser.setLastname(user.getLastname());
        updateUser.setUsername(user.getUsername());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        updateUser.setRole(user.getRole());
        log.trace("A venit {} si trebuie sa devina {}", user.getValidated(), updateUser.getValidated());
        updateUser.setValidated(user.getValidated());

        // daca parola e deja encodata si aceeasi, nu o schimba
        if (!Objects.equals(updateUser.getPassword(), user.getPassword())) {
            updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return updateUser;
    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteById --- method called; user={}", id);
        userRepository.deleteById(id);
        log.trace("deleteById --- method completed; deleteUsser={}", id);
    }

    @Transactional
    @Override
    public boolean resetPassword(String email, String newPassword) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found for email: " + email));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
