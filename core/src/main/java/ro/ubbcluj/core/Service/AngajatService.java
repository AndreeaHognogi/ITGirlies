package ro.ubbcluj.core.Service;

import ro.ubbcluj.core.Model.Angajat;
import ro.ubbcluj.core.Model.Specializare;

import java.util.List;

public interface AngajatService {
    List<Angajat> findAll();
    Angajat addAngajat (Angajat angajat);
    Angajat createAngajat (String nume, Integer salariu, Specializare specializare, Boolean disponibilitate, Boolean contValidat);
    Angajat updateAngajat (Angajat angajat);
    void deleteById(Long id);
}
