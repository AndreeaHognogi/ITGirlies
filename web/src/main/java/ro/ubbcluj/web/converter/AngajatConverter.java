//package ro.ubbcluj.web.converter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import ro.ubbcluj.core.model.Angajat;
//import ro.ubbcluj.core.model.Cerere;
//import ro.ubbcluj.web.dto.AngajatDto;
//
//@Component
//public class AngajatConverter extends AbstractConverterBaseEntityConverter<Angajat, AngajatDto> {
//    private static final Logger log = LoggerFactory.getLogger(AngajatConverter.class);
//
//    private final CerereConverter cerereConverter;
//    public AngajatConverter(CerereConverter cerereConverter) {
//        this.cerereConverter = cerereConverter;
//    }
//
//    @Override
//    public Angajat convertDtoToModel(AngajatDto angajatDto) {
//       Angajat angajat = new Angajat();
//        Cerere cerere = new Cerere();
//        cerere.setId(1L);
//        angajat.setNume(angajatDto.getNume());
//        angajat.setSalariu(angajatDto.getSalariu());
//        angajat.setDisponibilitate(angajatDto.getDisponibilitate());
//        angajat.setContValidat(angajatDto.getContValidat());
//        angajat.setRol(angajatDto.getRol());
//        return angajat;
//    }
//
//    @Override
//    public AngajatDto convertModelToDto(Angajat angajat) {
//        AngajatDto angajatDto = AngajatDto.builder()
//                .nume(angajat.getNume())
//                .salariu(angajat.getSalariu())
//                .disponibilitate(angajat.getDisponibilitate())
//                .contValidat(angajat.getContValidat())
//                .rol(angajat.getRol())
//                .build();
//        angajatDto.setId(angajat.getId());
//        return angajatDto;
//    }
//}
