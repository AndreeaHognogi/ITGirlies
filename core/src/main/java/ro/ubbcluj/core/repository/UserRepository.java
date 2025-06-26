package ro.ubbcluj.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubbcluj.core.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);

}
