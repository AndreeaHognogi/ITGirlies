package ro.ubbcluj.core.Service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubbcluj.core.Model.Angajat;
import ro.ubbcluj.core.Repository.AngajatRepository;
import ro.ubbcluj.core.Service.AngajatService;

import java.util.List;

@Service
public class AngajatServiceImpl implements AngajatService {
    private static final Logger log = LoggerFactory.getLogger(AngajatServiceImpl.class);

    @Autowired
    AngajatRepository angajatRepository;

    @Override
    public List<Angajat> findAll() {
        log.trace("getAllAngajati --- method called");
        List<Angajat> result = angajatRepository.findAll();
        log.trace("getAllAngajati --- method completed; result={}", result);
        return result;
    }

    @Override
    public Angajat addAngajat(Angajat angajat) {
        log.trace("getAllAngajati --- method called");
        Angajat result = angajatRepository.save(angajat);
        log.trace("getAllAngajati --- method completed; result={}", result);
        return result;
    }

    @Override
    public Angajat updateAngajat (Angajat angajat) {
        log.trace("updateAngajat --- method called");
        Angajat updateAngajat = angajatRepository.findById(angajat.getId()).orElse(new Angajat());
        updateAngajat.setName(angajat.getName());
        updateAngajat.setSalariu(angajat.getSalariu());
        updateAngajat.setSpecializare(angajat.getSpecializare());
        updateAngajat.setDisponibilitate(angajat.getDisponibilitate());
        updateAngajat.setCereri(angajat.getCereri());
        updateAngajat.setContValidat(angajat.getContValidat());
        log.trace("updateAngajat --- method completed; result={}", updateAngajat);
        return updateAngajat;
    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteById --- method called");
        angajatRepository.deleteById(id);
        log.trace("deleteById --- method completed; result={}", id);
    }
}
