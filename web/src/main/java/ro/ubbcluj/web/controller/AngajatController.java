//package ro.ubbcluj.web.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//import ro.ubbcluj.core.model.Angajat;
//import ro.ubbcluj.core.service.AngajatService;
//import ro.ubbcluj.web.converter.AngajatConverter;
//import ro.ubbcluj.web.dto.AngajatDto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class AngajatController {
//    private static final Logger log = LoggerFactory.getLogger(AngajatController.class);
//
//    @Autowired
//    private AngajatService angajatService;
//
//    @Autowired
//    private AngajatConverter angajatConverter;
//
//
//    @RequestMapping(value = "/angajats", method = RequestMethod.GET)
//    public List<AngajatDto> getAngajats() {
//        log.trace("getAngajats");
//
//        List<Angajat> angajats = angajatService.findAll();
//
//        log.trace("getAngajats: angajats={}", angajats);
//
//        return new ArrayList<>(angajatConverter.convertModelsToDtos(angajats));
//    }
//
//    @RequestMapping(value = "/angajats/{angajatId}", method = RequestMethod.GET)
//    public AngajatDto getAngajatById(@PathVariable("angajatId") final Long angajatId) {
//        log.trace("getAngajatById");
//        Angajat angajat = angajatService.findById(angajatId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Angajat not found"));
//        log.trace("getAngajatById: angajat={}", angajat);
//        return angajatConverter.convertModelToDto(angajat);
//    }
//
//    @RequestMapping(value = "/angajats/{angajatId}", method = RequestMethod.PUT)
//    public AngajatDto updateAngajat(
//            @PathVariable("angajatId") final Long angajatId,
//            @RequestBody final AngajatDto angajatDto) {
//        log.trace("updateAngajat: angajatId={}, angajatDtoMap={}", angajatId, angajatDto);
//
//        Angajat tempAngajat = new Angajat();
//        tempAngajat.setId(angajatId);
//        tempAngajat.setNume(angajatDto.getNume());
//        tempAngajat.setSalariu(angajatDto.getSalariu());
//        tempAngajat.setRol(angajatDto.getRol());
//        tempAngajat.setDisponibilitate(angajatDto.getDisponibilitate());
//        tempAngajat.setContValidat(angajatDto.getContValidat());
//
//       return angajatConverter.convertModelToDto(angajatService.updateAngajat(tempAngajat));
//    }
//
////    @RequestMapping(value = "/angajats", method = RequestMethod.POST)
////    public AngajatDto createAngajat(
////            @RequestBody final AngajatDto angajatDto) {
////        log.trace("createangajat: angajatDto={}", angajatDto);
////        if (angajatDto == null) {
////            throw new IllegalArgumentException("angajat data cannot be null");
////        }
////
////        // Call the service layer to save the angajat
////        Angajat angajat = angajatService.createAngajat(
////                angajatDto.getNume(),angajatDto.getSalariu(), angajatDto.getSpecializare(),
////                angajatDto.getDisponibilitate(), angajatDto.getContValidat() );
////
////        AngajatDto savedAngajat = angajatConverter.convertModelToDto(angajat);
////        // Return the saved angajat with its generated ID
////        return savedAngajat;
////    }
//
//    @RequestMapping(value = "/angajats", method = RequestMethod.POST)
//    public AngajatDto createAngajat(
//            @RequestBody final AngajatDto angajatDto) {
//       log.trace("createangajat: angajatDto={}", angajatDto);
//       AngajatDto resultAngajatDto = angajatConverter.convertModelToDto(
//               angajatService.createAngajat(
//               angajatConverter.convertDtoToModel(angajatDto)));
//
//        return resultAngajatDto;
//    }
//
//    @RequestMapping(value = "angajats/{angajatId}", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteAngajat(@PathVariable("angajatId") final Long angajatId) {
//        log.warn("deleteAngajat: angajatId: {}", angajatId);
//        try{
//            angajatService.deleteById(angajatId);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Error error) {
//            log.warn("Something went wrong while deleting angajat: {}", error);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//    }
//}
