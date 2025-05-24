package ro.ubbcluj.core.Service;

import ro.ubbcluj.core.Model.Cerere;

import java.util.List;

public interface CerereService {
    List<Cerere> findAll();
    Cerere addCerere(Cerere cerere);
    Cerere updateCerere(Long id, Cerere cerere);
    void deleteById(Long id);


}
