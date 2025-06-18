package ro.ubbcluj.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubbcluj.core.model.BaseEntity;
import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.model.Role;

import java.io.Serializable;
import java.util.List;

public interface CerereRepository extends JpaRepository<Cerere, Long> {

    List<Cerere> findByUserRole(Role role);
}
