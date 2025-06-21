package ro.ubbcluj.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubbcluj.core.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
