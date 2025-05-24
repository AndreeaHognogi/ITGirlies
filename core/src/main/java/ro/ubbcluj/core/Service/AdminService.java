package ro.ubbcluj.core.Service;

import ro.ubbcluj.core.Model.Administrator;

import java.util.List;

public interface AdminService {
    List<Administrator> findAll();
    Administrator addAdmin (Administrator administrator);
    Administrator updateAdmin (Administrator administrator);
    void deleteById(Long id);
}
