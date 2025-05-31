package ro.ubbcluj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.core.Model.Administrator;
import ro.ubbcluj.core.Service.AdminService;
import ro.ubbcluj.web.converter.AdministratorConverter;
import ro.ubbcluj.web.dto.AdministratorDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdministratorController {

    private static final Logger log = LoggerFactory.getLogger(AdministratorController.class);

    @Autowired
    private AdminService administratorService;

    @Autowired
    private AdministratorConverter administratorConverter;


    @RequestMapping(value = "/administrators", method = RequestMethod.GET)
    public List<AdministratorDto> getAdministrators() {
        log.trace("getAdministrators");

        List<Administrator> administrators = administratorService.findAll();

        log.trace("getAdministrators: administrators={}", administrators);

        return new ArrayList<>(administratorConverter.convertModelsToDtos(administrators));
    }

    @RequestMapping(value = "/administrators/{administratorId}", method = RequestMethod.PUT)
    public AdministratorDto updateAdministrator(
            @PathVariable final Long administratorId,
            @RequestBody final AdministratorDto administratorDto) {
        log.trace("updateAdministrator: administratorId={}, administratorDtoMap={}", administratorId, administratorDto);

        throw new RuntimeException("not yet implemented");
    }

    @RequestMapping(value = "/administrators", method = RequestMethod.POST)
    public AdministratorDto createAdministrator(
            @RequestBody final AdministratorDto administratorDto) {
        log.trace("createAdministrator: administratorDto={}", administratorDto);
        if (administratorDto == null) {
            throw new IllegalArgumentException("administrator data cannot be null");
        }

        // Call the service layer to save the administrator
        Administrator administrator = administratorService.createAdministrator(administratorDto.getNume(),administratorDto.getPhone(), administratorDto.getEmail() );

        AdministratorDto savedAdministrator = administratorConverter.convertModelToDto(administrator);
        // Return the saved administrator with its generated ID
        return savedAdministrator;
    }

    @RequestMapping(value = "administrators/{administratorId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAdministrator(@PathVariable final Long administratorId) {
        log.trace("deleteAdministrator: administratorId={}", administratorId);

        throw new RuntimeException("not yet implemented");
    }
}
