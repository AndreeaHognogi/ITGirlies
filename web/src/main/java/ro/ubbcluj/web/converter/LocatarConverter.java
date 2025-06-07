//package ro.ubbcluj.web.converter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import ro.ubbcluj.core.model.Cerere;
//import ro.ubbcluj.core.model.Locatar;
//import ro.ubbcluj.web.dto.LocatarDto;
//
//@Component
//public class LocatarConverter extends AbstractConverterBaseEntityConverter<Locatar, LocatarDto> {
//    private static final Logger log = LoggerFactory.getLogger(LocatarConverter.class);
//
//    private final CerereConverter cerereConverter;
//
//    @Autowired
//    public LocatarConverter(CerereConverter cerereConverter) {
//        this.cerereConverter = cerereConverter;
//    }
//
//    @Override
//    public Locatar convertDtoToModel(LocatarDto locatarDto) {
//        Locatar locatar = new Locatar();
//        Cerere cerere = new Cerere();
//        cerere.setId(1L);
//                locatar.setNume(locatarDto.getNume());
//                locatar.setNumarCamera(locatarDto.getNumarCamera());
//                locatar.setContValidat(locatarDto.getContValidat());
//        return locatar;
//    }
//
//    @Override
//    public LocatarDto convertModelToDto(Locatar locatar) {
//        LocatarDto locatarDto = LocatarDto.builder()
//                .nume(locatar.getNume())
//                .numarCamera(locatar.getNumarCamera())
//                .contValidat(locatar.getContValidat())
//                .build();
//        locatarDto.setId(locatar.getId());
//        return locatarDto;
//    }
//}
