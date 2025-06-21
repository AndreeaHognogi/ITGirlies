package ro.ubbcluj.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.core.model.Status;
import ro.ubbcluj.web.dto.CerereDto;

import java.time.LocalDate;

@Component
public class CerereConverter extends AbstractConverterBaseEntityConverter<Cerere, CerereDto>{

    private static final Logger log = LoggerFactory.getLogger(CerereConverter.class);

    @Override
    public Cerere convertDtoToModel(CerereDto cerereDto) {
        Cerere cerere = new Cerere();
        cerere.setSubiect(cerereDto.getSubiect());
        cerere.setDescriere(cerereDto.getDescriere());
        cerere.setData(LocalDate.parse(cerereDto.getData()));
        cerere.setStatus(cerereDto.getStatus());
        return cerere;

    }

    @Override
    public CerereDto convertModelToDto(Cerere cerere) {
        CerereDto cerereDto = CerereDto.builder()
                .subiect(cerere.getSubiect())
                .descriere(cerere.getDescriere())
                .data(cerere.getData().toString())
                .status(cerere.getStatus())
                .build();
        cerereDto.setId(cerere.getId());

    return cerereDto;
    }
}

