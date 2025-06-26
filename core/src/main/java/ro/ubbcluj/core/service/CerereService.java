package ro.ubbcluj.core.service;

import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.model.Status;

import java.util.List;
import java.util.Optional;

public interface CerereService {
    List<Cerere> findAll();
    Optional<Cerere> findById(Long id);
    Cerere addCerere(Cerere cerere);
    Cerere updateCerere(Cerere cerere);
    void deleteById(Long id);
    List<Cerere> getCereriByUserId(Long userId);
//    List<Cerere> getCereriByUserIdAndStatus(Long userId, Status status);

 List<Cerere> getCereriForUser(String username);

}
