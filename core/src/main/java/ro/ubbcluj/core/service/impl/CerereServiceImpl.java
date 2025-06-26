package ro.ubbcluj.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.model.Status;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.core.repository.CerereRepository;
import ro.ubbcluj.core.repository.UserRepository;
import ro.ubbcluj.core.service.CerereService;

import java.util.List;
import java.util.Optional;

@Service
public class CerereServiceImpl implements CerereService {

    private static final Logger log = LoggerFactory.getLogger(CerereServiceImpl.class);

    @Autowired
    CerereRepository cerereRepository;

    @Autowired
    UserRepository userRepository;

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
        return result;
    }
//
//    // Metodă helper pentru a obține utilizatorul curent
//    private User getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        return userRepository.findByUsername(username)
//                .orElseThrow(() -> new IllegalStateException("User not found: " + username));
//    }
    @Transactional
    @Override
    public Cerere addCerere(Cerere cerere) {
        log.trace("addCerere: cerere={}", cerere);

//        // Dacă user-ul nu este setat, ia utilizatorul curent din SecurityContext
        if (cerere.getUser() == null) {
            org.springframework.security.core.userdetails.User userAuthenticated =
            (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

            ro.ubbcluj.core.model.User dbUser = userRepository.findAll().stream()
                    .filter(u -> u.getEmail().equals(userAuthenticated.getUsername()))
                    .findFirst().orElseThrow();

            cerere.setUser(dbUser);
            log.debug("Set current user for cerere: {}", dbUser.getUsername());
        }
        // Setează status default dacă este null
        if (cerere.getStatus() == null) {
            cerere.setStatus(Status.PENDING);
            log.debug("Status was null, set to PENDING for cerere: {}", cerere);
        }
        Cerere result = cerereRepository.save(cerere);
        log.trace("addCerere: result={}", result);
        return result;
    }

    @Transactional
    @Override
    public Cerere updateCerere(Cerere cerere) {
        log.trace("updateCerere --- method calle; cerere={}", cerere);
//        Cerere updateCerere = cerereRepository.findById(cerere.getId())
//                .orElseThrow(() -> new IllegalArgumentException("Cererea nu exista!"));
       Cerere updateCerere = cerereRepository.findById(cerere.getId()).orElse(new Cerere());
        log.trace("updateCerere: cerere={}", cerere);
        updateCerere.setSubiect(cerere.getSubiect());
        updateCerere.setDescriere(cerere.getDescriere());
        updateCerere.setData(cerere.getData());

        if (cerere.getUser() != null) {
            updateCerere.setUser(cerere.getUser());
        }

        // Setează status - dacă este null, păstrează valoarea existentă sau setează PENDING
        if (cerere.getStatus() != null) {
            updateCerere.setStatus(cerere.getStatus());
        } else if (updateCerere.getStatus() == null) {
            updateCerere.setStatus(Status.PENDING);
            log.debug("Status was null, set to PENDING for update cerere: {}", updateCerere);
        }
        //updateCerere.setUser(cerere.getUser());
        updateCerere = cerereRepository.save(updateCerere);
        return updateCerere;
    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteCerere: cerere={}", id);
        cerereRepository.deleteById(id);
        log.trace("deleteOrder: result={}", id);
    }

    @Override
    public List<Cerere> getCereriByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return cerereRepository.findByUser(user);
    }

    @Override
    public List<Cerere> getCereriByUserIdAndStatus(Long userId, Status status) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return cerereRepository.findByUserAndStatus(user, status);
    }


}
