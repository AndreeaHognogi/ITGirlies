package ro.ubbcluj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ro.ubbcluj.core.model.Locatar;
import ro.ubbcluj.core.service.LocatarService;
import ro.ubbcluj.web.converter.LocatarConverter;
import ro.ubbcluj.web.dto.LocatarDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LocatarController {
    private static final Logger log = LoggerFactory.getLogger(LocatarController.class);
    @Autowired
    private LocatarService locatarService;
    @Autowired
    private LocatarConverter locatarConverter;

    @RequestMapping(value= "/locatars", method = RequestMethod.GET)
    public List<LocatarDto> getlocatars() {
        log.trace("getlocatars");
        List<Locatar> locatars = locatarService.findAll();
        log.trace("getlocatars: locatars: {}", locatars);
        return new ArrayList<>(locatarConverter.convertModelsToDtos(locatars));
    }
    @RequestMapping(value= "/locatars/{locatarId}", method = RequestMethod.GET)
    public LocatarDto getlocatarById(@PathVariable("locatarId") final Long locatarId) {
        log.trace("getlocatarById");
        Locatar locatar = locatarService.findById(locatarId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locatar not found"));
        log.trace("getlocatarById: locatar: {}", locatar);
        return locatarConverter.convertModelToDto(locatar);
    }

    @RequestMapping(value = "/locatars", method = RequestMethod.POST)
    public LocatarDto createlocatar(
            @RequestBody final LocatarDto locatarDto) {
        log.trace("createlocatar: locatarDto: {}", locatarDto);
        LocatarDto resultLocatarDto = locatarConverter.convertModelToDto(
                locatarService.addLocatar(
                        locatarConverter.convertDtoToModel(locatarDto)));
        return resultLocatarDto;
    }
    @RequestMapping(value = "/locatars/{locatarId}", method = RequestMethod.PUT)
    public LocatarDto updateLocatar(
            @PathVariable("locatarId") final Long locatarId,
            @RequestBody final LocatarDto locatarDto){
        log.trace("updateLocatar: locatarDto: {}", locatarDto);
        Locatar tempLocatar = new Locatar();
        tempLocatar.setId(locatarId);
        tempLocatar.setNume(locatarDto.getNume());
        tempLocatar.setNumarCamera(locatarDto.getNumarCamera());
        tempLocatar.setContValidat(locatarDto.getContValidat());
        return locatarConverter.convertModelToDto(
                locatarService.updateLocatar(tempLocatar));
    }

    @RequestMapping(value = "/locatars/{locatarId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteLocatar(@PathVariable("locatarId") final Long locatarId) {
        log.warn("deleteLocatar: locatarId: {}", locatarId);
        try{
            locatarService.deleteById(locatarId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Error error) {
            log.warn("Something went wrong while deleting locatar: {}", error);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
