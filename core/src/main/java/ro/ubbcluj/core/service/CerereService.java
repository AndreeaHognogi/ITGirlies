package ro.ubbcluj.core.service;

import ro.ubbcluj.core.model.Cerere;

import java.util.List;
import java.util.Optional;

public interface CerereService {
    List<Cerere> findAll();
    Optional<Cerere> findById(Long id);
    Cerere addCerere(Cerere cerere);
    Cerere updateCerere(Long id, Cerere cerere);
    void deleteById(Long id);


}
