package ro.ubbcluj.core.service.impl;

import org.hibernate.usertype.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.model.Role;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.core.repository.CerereRepository;
import ro.ubbcluj.core.service.CerereService;

import java.util.List;
import java.util.Objects;
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
        log.info("findById --- method called; cerere = {}", id);
       Optional<Cerere> result = cerereRepository.findById(id);
       log.trace("findById: result={}", result);
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
    public Cerere updateCerere(Cerere cerere) {
        log.trace("updateCerere --- method calle; cerere={}", cerere);
//        Cerere updateCerere = cerereRepository.findById(cerere.getId())
//                .orElseThrow(() -> new IllegalArgumentException("Cererea nu exista!"));
       Cerere updateCerere = (Cerere) cerereRepository.findById(cerere.getId()).orElse(new Cerere());
        log.trace("updateCerere: cerere={}", cerere);
        updateCerere.setSubiect(cerere.getSubiect());
        updateCerere.setDescriere(cerere.getDescriere());
        updateCerere.setData(cerere.getData());
        updateCerere.setStatus(cerere.getStatus());
        updateCerere.setUser(cerere.getUser());
        updateCerere = (Cerere) cerereRepository.save(updateCerere);
        return updateCerere;
    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteCerere: cerere={}", id);
        cerereRepository.deleteById(id);
        log.trace("deleteOrder: result={}", id);
    }

    public List<Cerere> findByRole(Role role) {
        return cerereRepository.findByUserRole(role);
    }

}
