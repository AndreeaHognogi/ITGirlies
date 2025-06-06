package ro.ubbcluj.core.service;

import ro.ubbcluj.core.model.Angajat;

import java.util.List;
import java.util.Optional;

public interface AngajatService {
    List<Angajat> findAll();
    Optional<Angajat> findById(Long id);
    Angajat createAngajat (Angajat angajat);
    Angajat updateAngajat (Angajat angajat);
    void deleteById(Long id);
}
