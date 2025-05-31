package ro.ubbcluj.core.Service;

import jakarta.persistence.Column;
import ro.ubbcluj.core.Model.Administrator;

import java.util.List;

public interface AdminService {
    List<Administrator> findAll();
    Administrator addAdmin (Administrator administrator);
    Administrator updateAdmin (Administrator administrator);
    Administrator createAdministrator (String nume, String phone, String email);
    void deleteById(Long id);
}
