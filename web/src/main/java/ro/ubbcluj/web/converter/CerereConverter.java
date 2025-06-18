package ro.ubbcluj.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.model.Status;
import ro.ubbcluj.web.dto.CerereDto;

import java.time.LocalDate;

@Component
public class CerereConverter extends AbstractConverter<Cerere, CerereDto>{

    private static final Logger log = LoggerFactory.getLogger(CerereConverter.class);

    @Override
    public Cerere convertDtoToModel(CerereDto cerereDto) {
    Cerere cerere = Cerere.builder()
            .subiect(cerereDto.getSubiect())
            .descriere(cerereDto.getDescriere())
            .data(cerereDto.getData())
            .status(cerereDto.getStatus())
            .user(cerereDto.getUser())
            .build();
        return cerere;
    }

    @Override
    public CerereDto convertModelToDto(Cerere cerere) {
        CerereDto cerereDto = CerereDto.builder()
                .subiect(cerere.getSubiect())
                .descriere(cerere.getDescriere())
                .data(cerere.getData())
                .status(cerere.getStatus())
                .user(cerere.getUser())
                .build();

    return cerereDto;
    }
}

