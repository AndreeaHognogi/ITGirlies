package ro.ubbcluj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.model.User;
import ro.ubbcluj.core.service.CerereService;
import ro.ubbcluj.core.service.UserService;
import ro.ubbcluj.web.converter.CerereConverter;
import ro.ubbcluj.web.converter.UserConverter;
import ro.ubbcluj.web.dto.CerereDto;
import ro.ubbcluj.web.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CerereController {
    private static final Logger log = LoggerFactory.getLogger(CerereController.class);

    @Autowired
    private CerereService cerereService;

    @Autowired
    CerereConverter cerereConverter;

    @RequestMapping(value= "/cereri", method = RequestMethod.GET)
    public List<CerereDto> getCereri() {
        log.trace("getCereri");
        List<Cerere> cereri = cerereService.findAll();
        log.trace("getCereri: cereri: {}", cereri);
        return  new ArrayList<>(cerereConverter.convertModelsToDtos(cereri));
    }

    @RequestMapping(value= "/cereri/users", method = RequestMethod.GET)
    public List<CerereDto> getCereriForCurrentUser() {
        return List.of();
    }

    @RequestMapping(value = "/cereri/{cerereId}", method = RequestMethod.GET)
    public CerereDto getCerereById(@PathVariable("cerereId") final Long cerereId) {
        log.trace("getCerereById");
        Cerere cerere = cerereService.findById(cerereId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Cerere not found"));
        log.trace("getCerereById: cerere: {}", cerere);
        return cerereConverter.convertModelToDto(cerere);
    }

    @RequestMapping(value = "/cereri", method = RequestMethod.POST)
    public CerereDto createCerere(@RequestBody final CerereDto cerereDto,
                                  @RequestHeader("authorization") String jwt) {
        log.trace("createCerere: cerereDto: {}", cerereDto);
        CerereDto resultCerereDto = cerereConverter.convertModelToDto(
                cerereService.addCerere(cerereConverter.convertDtoToModel(cerereDto)));
        return resultCerereDto;
    }

    @RequestMapping(value = "/cereri/{cerereId}", method = RequestMethod.PUT)
    public CerereDto updateCerere(
            @PathVariable("cerereId") final Long cerereId,
            @RequestBody final CerereDto cerereDto) {
        log.trace("updateCerere: cerereDto: {}", cerereDto);
        Cerere tempCerere = new Cerere();
        tempCerere.setId(cerereId);
        tempCerere.setSubiect(cerereDto.getSubiect());
        tempCerere.setDescriere(cerereDto.getDescriere());
        tempCerere.setData(cerereDto.getData());
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
