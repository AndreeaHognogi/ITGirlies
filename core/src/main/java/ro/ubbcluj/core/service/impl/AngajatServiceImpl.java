package ro.ubbcluj.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.core.model.Angajat;
import ro.ubbcluj.core.model.Specializare;
import ro.ubbcluj.core.repository.AngajatRepository;
import ro.ubbcluj.core.service.AngajatService;

import java.util.List;
import java.util.Optional;

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
    public Optional<Angajat> findById(Long id) {
        log.info("findById --- method called; angajat={}", id);
        Optional<Angajat> result = angajatRepository.findById(id);
        log.info("findOne --- method completed; result={}", result);
        return result;
    }

    @Transactional
    @Override
    public Angajat createAngajat(Angajat angajat) {
        log.trace("getAllAngajati --- method called");
        Angajat result = angajatRepository.save(angajat);
        log.trace("getAllAngajati --- method completed; result={}", result);
        return result;
    }

    @Transactional
    @Override
    public Angajat updateAngajat (Angajat angajat) {
        log.trace("updateAngajat --- method called");
        Angajat updateAngajat = angajatRepository.findById(angajat.getId()).orElse(new Angajat());
        updateAngajat.setNume(angajat.getNume());
        updateAngajat.setSalariu(angajat.getSalariu());
        updateAngajat.setSpecializare(angajat.getSpecializare());
        updateAngajat.setDisponibilitate(angajat.getDisponibilitate());
        updateAngajat.setCereri(angajat.getCereri());
        updateAngajat.setContValidat(angajat.getContValidat());
        log.trace("updateAngajat --- method completed; result={}", updateAngajat);
        return updateAngajat;
    }
//    @Override
//    public Angajat createAngajat(String nume, Integer salariu, Specializare specializare, Boolean disponibilitate, Boolean contValidat) {
//        log.trace("createAngajat: nume={}, salariu={},specializare={}, disponibilitate={}, contValidat={}",
//                nume, salariu,specializare, disponibilitate, contValidat);
//
//        // Validate inputs
//        if (nume == null || nume.trim().isEmpty()) {
//            throw new IllegalArgumentException("Angajat name cannot be null or empty");
//        }
//
//        Angajat angajat = new Angajat();
//        angajat.setNume(nume);
//        angajat.setSalariu(salariu);
//        angajat.setSpecializare(specializare);
//        angajat.setDisponibilitate(disponibilitate);
//        angajat.setContValidat(contValidat);
//
//
//        // Save the angajat using the repository
//        return angajatRepository.save(angajat);
//    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteById --- method called");
        angajatRepository.deleteById(id);
        log.trace("deleteById --- method completed; result={}", id);
    }
}
