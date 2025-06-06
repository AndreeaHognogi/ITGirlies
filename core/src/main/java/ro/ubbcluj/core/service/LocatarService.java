package ro.ubbcluj.core.service;

import ro.ubbcluj.core.model.Locatar;

import java.util.List;
import java.util.Optional;

public interface LocatarService {
    List<Locatar> findAll();
    Optional<Locatar> findById(Long id);
    Locatar addLocatar (Locatar locatar);
    Locatar updateLocatar (Locatar locatar);
    void deleteById(Long id);
}
