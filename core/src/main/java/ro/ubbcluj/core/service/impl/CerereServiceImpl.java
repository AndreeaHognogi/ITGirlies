package ro.ubbcluj.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.repository.CerereRepository;
import ro.ubbcluj.core.service.CerereService;

import java.util.List;
import java.util.Optional;

@Service
public class CerereServiceImpl implements CerereService {

    private static final Logger log = LoggerFactory.getLogger(CerereServiceImpl.class);

    @Autowired
    CerereRepository cerereRepository;

    @Override
    public List<Cerere> findAll() {
        log.trace("getAllCereri --- method entered");

        List<Cerere> result = cerereRepository.findAll();

        log.trace("getAllCereri: result={}", result);

        return result;
    }

    @Override
    public Optional<Cerere> findById(Long id) {

//        log.info("findById --- method called; cerere = {}", id);
//        List<Cerere> result = cerereRepository.findAll();
//        log.trace("findById: result={}", result);
        return Optional.empty();
    }

    @Transactional
    @Override
    public Cerere addCerere(Cerere cerere) {
        log.trace("addCerere: cerere={}", cerere);

        Cerere result = (Cerere) cerereRepository.save(cerere);

        log.trace("addCerere: result={}", result);

        return result;
    }

    @Transactional
    @Override
    public Cerere updateCerere(Long id, Cerere cerere) {
        return null;
    }

//    @Override
//    public Cerere updateCerere(Long id, Cerere cerere) {
//        log.trace("updateCerere: cerere={}", cerere);
//
//        Cerere result = cerereRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Cererea cu ID " + id + " nu exista!"));
//        result.setAngajat(cerere.getAngajat());
//        result.setStatus(cerere.getStatus());
//        result.setCategorie(cerere.getCategorie());
//        result.setLocatar(cerere.getLocatar());
//        result.setProblema(cerere.getProblema());
//        result = (Cerere) cerereRepository.save(result);
//        log.trace("updateCerere: result={}", result);
//        return result;
//        //metoda aceasta nu sunt sigura ca e buna
//    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteCerere: cerere={}", id);
        cerereRepository.deleteById(id);
        log.trace("deleteOrder: result={}", id);
    }
}
