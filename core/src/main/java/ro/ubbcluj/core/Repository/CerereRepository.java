package ro.ubbcluj.core.Repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubbcluj.core.Model.BaseEntity;

import java.io.Serializable;

public interface CerereRepository <T extends BaseEntity<ID>, ID extends Serializable>
                extends JpaRepository<T, ID> {
}
