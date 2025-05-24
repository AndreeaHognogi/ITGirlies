package ro.ubbcluj.core.Service;

import ro.ubbcluj.core.Model.Locatar;

import java.util.List;

public interface LocatarService {
    List<Locatar> findAll();
    Locatar addLocatar (Locatar locatar);
    Locatar updateLocatar (Locatar locatar);
    void deleteById(Long id);
}
