package ro.ubbcluj.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubbcluj.core.model.*;

import java.io.Serializable;
import java.util.List;

public interface CerereRepository extends JpaRepository<Cerere, Long> {

    List<Cerere> findByUser(User username);

//    List<Cerere> findByUserAndStatus(User username, Status status);

}
