package ro.ubbcluj.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.core.repository.UserRepository;
import ro.ubbcluj.core.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

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
        User result = userRepository.save(user);
        log.trace("addUser --- method completed; result={}", result);
        return result;
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        log.trace("updateUser --- method called; user={}", user);
        User updateUser = userRepository.findById(user.getId()).orElse(new User());
        updateUser.setUsermane(user.getUsermane());
        updateUser.setPassword(user.getPassword());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        updateUser.setRole(user.getRole());
        updateUser.setValidated(user.getValidated());
        return updateUser;
    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteById --- method called; user={}", id);
        userRepository.deleteById(id);
        log.trace("deleteById --- method completed; deleteUsser={}", id);
    }
}
