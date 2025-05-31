package ro.ubbcluj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.core.Model.Angajat;
import ro.ubbcluj.core.Service.AngajatService;
import ro.ubbcluj.web.converter.AngajatConverter;
import ro.ubbcluj.web.dto.AngajatDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AngajatController {
    private static final Logger log = LoggerFactory.getLogger(AngajatController.class);

    @Autowired
    private AngajatService angajatService;

    @Autowired
    private AngajatConverter angajatConverter;


    @RequestMapping(value = "/angajats", method = RequestMethod.GET)
    public List<AngajatDto> getAngajats() {
        log.trace("getangajats");

        List<Angajat> angajats = angajatService.findAll();

        log.trace("getangajats: angajats={}", angajats);

        return new ArrayList<>(angajatConverter.convertModelsToDtos(angajats));
    }

    @RequestMapping(value = "/angajats/{angajatId}", method = RequestMethod.PUT)
    public AngajatDto updateangajat(
            @PathVariable final Long angajatId,
            @RequestBody final AngajatDto angajatDto) {
        log.trace("updateangajat: angajatId={}, angajatDtoMap={}", angajatId, angajatDto);

        throw new RuntimeException("not yet implemented");
    }

    @RequestMapping(value = "/angajats", method = RequestMethod.POST)
    public AngajatDto createAngajat(
            @RequestBody final AngajatDto angajatDto) {
        log.trace("createangajat: angajatDto={}", angajatDto);
        if (angajatDto == null) {
            throw new IllegalArgumentException("angajat data cannot be null");
        }

        // Call the service layer to save the angajat
        Angajat angajat = angajatService.createAngajat(angajatDto.getNume(),angajatDto.getSalariu(), angajatDto.getSpecializare(), angajatDto.getDisponibilitate(), angajatDto.getContValidat() );

        AngajatDto savedangajat = angajatConverter.convertModelToDto(angajat);
        // Return the saved angajat with its generated ID
        return savedangajat;
    }

    @RequestMapping(value = "angajats/{angajatId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteangajat(@PathVariable final Long angajatId) {
        log.trace("deleteAngajat: angajatId={}", angajatId);

        throw new RuntimeException("not yet implemented");
    }

}
