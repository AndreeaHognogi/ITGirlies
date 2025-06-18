package ro.ubbcluj.core.service;

import org.hibernate.usertype.UserType;
import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.model.Role;

import java.util.List;
import java.util.Optional;

public interface CerereService {
    List<Cerere> findAll();
    Optional<Cerere> findById(Long id);
    Cerere addCerere(Cerere cerere);
    Cerere updateCerere(Cerere cerere);
    void deleteById(Long id);

}
