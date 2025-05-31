package ro.ubbcluj.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubbcluj.core.Model.Angajat;
import ro.ubbcluj.core.Model.Specializare;
import ro.ubbcluj.web.dto.AngajatDto;

@Component
public class AngajatConverter extends AbstractConverterBaseEntityConverter<Angajat, AngajatDto> {
    private static final Logger log = LoggerFactory.getLogger(AngajatConverter.class);


    @Override
    public Angajat convertDtoToModel(AngajatDto angajatDto) {
       Angajat angajat = Angajat.builder()
               .nume(angajatDto.getNume())
               .salariu(angajatDto.getSalariu())
               .disponibilitate(angajatDto.getDisponibilitate())
               .contValidat(angajatDto.getContValidat())
               .specializare(angajatDto.getSpecializare())
               .build();
       angajat.setId(angajatDto.getId());
        return angajat;
    }

    @Override
    public AngajatDto convertModelToDto(Angajat angajat) {
        AngajatDto angajatDto = AngajatDto.builder()
                .nume(angajat.getNume())
                .salariu(angajat.getSalariu())
                .disponibilitate(angajat.getDisponibilitate())
                .contValidat(angajat.getContValidat())
                .specializare(angajat.getSpecializare())
                .build();
        angajatDto.setId(angajat.getId());
        return angajatDto;
    }
}
//private String nume;
//private Integer salariu;
//private Specializare specializare;
//private Boolean disponibilitate;
//private Boolean contValidat;