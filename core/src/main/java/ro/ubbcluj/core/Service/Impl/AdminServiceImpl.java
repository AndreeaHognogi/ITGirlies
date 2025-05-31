package ro.ubbcluj.core.Service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubbcluj.core.Model.Administrator;
import ro.ubbcluj.core.Repository.AdminRepository;
import ro.ubbcluj.core.Service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<Administrator> findAll() {
        log.trace("getAllAdmins --- method called");
        List<Administrator> result = adminRepository.findAll();
        log.trace("getAllAdmins --- method completed; result={}", result);
        return result;
    }

    @Override
    public Administrator addAdmin(Administrator administrator) {
        log.trace("getAllAdmins --- method called");
        Administrator result = adminRepository.save(administrator);
        log.trace("getAllAdmins --- method completed; result={}", result);
        return result;
    }

    @Override
    public Administrator updateAdmin(Administrator administrator) {
        log.trace("updateAdmin --- method called");
        Administrator updateAdmin= adminRepository.findById(administrator.getId()).orElse(new Administrator());
        updateAdmin.setNume(administrator.getNume());
        updateAdmin.setPhone(administrator.getPhone());
        updateAdmin.setEmail(administrator.getEmail());
        log.trace("updateAdmin --- method completed; result={}", updateAdmin);
        return updateAdmin;
    }

    @Override
    public Administrator createAdministrator(String nume, String email, String phone) {
        log.trace("createAdministrator: nume={}, email={}, phone={}",
                nume, email, phone);

        // Validate inputs
        if (nume == null || nume.trim().isEmpty()) {
            throw new IllegalArgumentException("Administrator name cannot be null or empty");
        }

        Administrator administrator = new Administrator();
        administrator.setNume(nume);
        administrator.setEmail(email);
        administrator.setPhone(phone);

        // Save the administrator using the repository
        return adminRepository.save(administrator);
    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteById --- method called");
        adminRepository.deleteById(id);
        log.trace("deleteById --- method completed; result={}", id);
    }
}
