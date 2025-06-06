package ro.ubbcluj.core.service;

import ro.ubbcluj.core.model.Administrator;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Administrator> findAll();
    Optional<Administrator> findById(Long id);
    Administrator updateAdmin (Administrator administrator);
    Administrator createAdministrator (String nume, String phone, String email);
    void deleteById(Long id);
}
