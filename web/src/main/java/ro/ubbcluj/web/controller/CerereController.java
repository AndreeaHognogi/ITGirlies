package ro.ubbcluj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.core.service.CerereService;
import ro.ubbcluj.core.service.UserService;
import ro.ubbcluj.web.converter.CerereConverter;
import ro.ubbcluj.web.dto.CerereDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CerereController {
    private static final Logger log = LoggerFactory.getLogger(CerereController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CerereService cerereService;

    @Autowired
    private CerereConverter cerereConverter;

//    @PreAuthorize("hasRole('Admin')")
    @RequestMapping(value= "/cereri", method = RequestMethod.GET)
    public List<CerereDto> getCereri(Authentication authentication) {
        // admin vede toate cererile
        List<Cerere> cereri = cerereService.findAll();
        return  new ArrayList<>(cerereConverter.convertModelsToDtos(cereri));
    }

    @GetMapping("/cereri-for-users")
    public List<CerereDto> getCereriForUser(Authentication authentication) {
        String username = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();
        log.trace("getCereriForUser - username: {}", username);
        User user = userService.findUserByEmail(username);
        List<Cerere> cereri = cerereService.getCereriByUserId(user.getId());
        return new ArrayList<>(cerereConverter.convertModelsToDtos(cereri));
    }

    @RequestMapping(value = "/cereri/{cerereId}", method = RequestMethod.GET)
    public CerereDto getCerereById(@PathVariable("cerereId") final Long cerereId) {
        log.trace("getCerereById");
        Cerere cerere = cerereService.findById(cerereId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Cerere not found"));
        log.trace("getCerereById: cerere: {}", cerere);
        return cerereConverter.convertModelToDto(cerere);
    }

    @RequestMapping(value = "/cereri", method = RequestMethod.POST)
    public CerereDto createCerere(@RequestBody final CerereDto cerereDto) {
        log.trace("createCerere: cerereDto: {}", cerereDto);
        CerereDto resultCerereDto = cerereConverter.convertModelToDto(
                cerereService.addCerere(cerereConverter.convertDtoToModel(cerereDto)));
        return resultCerereDto;
    }

    @RequestMapping(value = "/cereri/{cerereId}", method = RequestMethod.PUT)
    public CerereDto updateCerere(
            @PathVariable("cerereId") final Long cerereId,
            @RequestBody final CerereDto cerereDto,
            @RequestHeader("authorization") String jwt) {
        log.trace("updateCerere: cerereDto: {}", cerereDto);
        Cerere tempCerere = new Cerere();
        tempCerere.setId(cerereId);
        tempCerere.setSubiect(cerereDto.getSubiect());
        tempCerere.setDescriere(cerereDto.getDescriere());
        tempCerere.setData(LocalDate.parse(cerereDto.getData()));
        tempCerere.setStatus(cerereDto.getStatus());
        return cerereConverter.convertModelToDto(cerereService.updateCerere(tempCerere));
    }

    @RequestMapping(value = "/cereri/{cerereId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCerere(@PathVariable("cerereId") final Long cerereId) {
        log.warn("deleteCerere: cerereId: {}", cerereId);
        try{
            cerereService.deleteById(cerereId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Error error) {
            log.warn("Something went wrong while deleting cerere: {}", error);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
