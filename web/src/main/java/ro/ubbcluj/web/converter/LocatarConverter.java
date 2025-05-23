package ro.ubbcluj.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.ubbcluj.core.Model.Locatar;
import ro.ubbcluj.web.dto.LocatarDto;

public class LocatarConverter extends AbstractConverterBaseEntityConverter<Locatar, LocatarDto> {
    private static final Logger log = LoggerFactory.getLogger(LocatarConverter.class);


    @Override
    public Locatar convertDtoToModel(LocatarDto locatarDto) {
        Locatar locatar = Locatar.builder()
                .nume(locatarDto.getNume())
                .numarCamera(locatarDto.getNumarCamera())
                .contValidat(locatarDto.getContValidat())
                .build();
        locatar.setId(locatarDto.getId());
        return locatar;
    }

    @Override
    public LocatarDto convertModelToDto(Locatar locatar) {
        LocatarDto locatarDto = LocatarDto.builder()
                .nume(locatar.getNume())
                .numarCamera(locatar.getNumarCamera())
                .contValidat(locatar.getContValidat())
                .build();
        locatarDto.setId(locatar.getId());
        return locatarDto;
    }
}

//private String nume;
//private Integer numarCamera;
//private Boolean contValidat;