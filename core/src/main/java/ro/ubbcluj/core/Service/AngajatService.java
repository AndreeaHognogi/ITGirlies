package ro.ubbcluj.core.Service;

import ro.ubbcluj.core.Model.Angajat;

import java.util.List;

public interface AngajatService {
    List<Angajat> findAll();
    Angajat addAngajat (Angajat angajat);
    Angajat updateAngajat (Angajat angajat);
    void deleteById(Long id);
}
