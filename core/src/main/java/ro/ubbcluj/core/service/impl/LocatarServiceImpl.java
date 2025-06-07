//package ro.ubbcluj.core.service.impl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import ro.ubbcluj.core.model.Locatar;
//import ro.ubbcluj.core.repository.LocatarRepository;
//import ro.ubbcluj.core.service.LocatarService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class LocatarServiceImpl implements LocatarService {
//    private static final Logger log = LoggerFactory.getLogger(LocatarServiceImpl.class);
//    @Autowired
//    LocatarRepository locatarRepository;
//
//    @Override
//    public List<Locatar> findAll() {
//        log.trace("findAllLocatari --- method called");
//        List<Locatar> result = locatarRepository.findAll();
//        log.trace("findAllLocatari --- method completed; result={}", result);
//        return result;
//    }
//
//    @Override
//    public Optional<Locatar> findById(Long id) {
//        log.info("findById --- method called; locatar={}", id);
//        Optional<Locatar> result = locatarRepository.findById(id);
//        log.info("findById --- method completed; result={}", result);
//        return result;
//    }
//
//    @Transactional
//    @Override
//    public Locatar addLocatar(Locatar locatar) {
//        log.trace("addLocatar --- method called; locatar={}", locatar);
//        Locatar result = locatarRepository.save(locatar);
//        log.trace("addLocatar --- method completed; result={}", result);
//        return result;
//    }
//
//    @Transactional
//    @Override
//    public Locatar updateLocatar(Locatar locatar) {
//        log.trace("updateLocatar --- method called; locatar={}", locatar);
//        Locatar updateLocatar = locatarRepository.findById(locatar.getId()).orElse(new Locatar());
//        updateLocatar.setNume(locatar.getNume());
//        updateLocatar.setCerere(locatar.getCerere());
//        updateLocatar.setNumarCamera(locatar.getNumarCamera());
//        updateLocatar.setContValidat(locatar.getContValidat());
//        log.trace("updateLocatar --- method completed; updateBook={}", updateLocatar);
//        return updateLocatar;
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        log.trace("deleteById --- method called; locatar={}", id);
//        locatarRepository.deleteById(id);
//        log.trace("deleteById --- method completed; deletelocatar={}", id);
//    }
//}
