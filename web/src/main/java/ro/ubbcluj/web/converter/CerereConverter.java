package ro.ubbcluj.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubbcluj.core.model.Cerere;
import ro.ubbcluj.web.dto.CerereDto;

@Component
public class CerereConverter extends AbstractConverter<Cerere, CerereDto>{

    private static final Logger log = LoggerFactory.getLogger(CerereConverter.class);

    @Override
    public Cerere convertDtoToModel(CerereDto cerereDto) {
    Cerere cerere = Cerere.builder()
            .locatar(cerereDto.getLocatar())
            .angajat(cerereDto.getAngajat())
            .problema(cerereDto.getProblema())
          //  .categorie(cerereDto.getCategorie())
            .status(cerereDto.getStatus())
            .build();
    return cerere;
    }

    @Override
    public CerereDto convertModelToDto(Cerere cerere) {
        CerereDto cerereDto = CerereDto.builder()
                .locatar(cerere.getLocatar())
                .angajat(cerere.getAngajat())
                .problema(cerere.getProblema())
             //   .categorie(cerere.getCategorie())
                .status(cerere.getStatus())
                .build();
    return cerereDto;}
}

