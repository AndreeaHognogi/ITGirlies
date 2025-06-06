package ro.ubbcluj.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubbcluj.core.model.BaseEntity;

import java.io.Serializable;

public interface CerereRepository <T extends BaseEntity<ID>, ID extends Serializable>
                extends JpaRepository<T, ID> {
}
