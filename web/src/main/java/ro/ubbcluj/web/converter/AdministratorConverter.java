//package ro.ubbcluj.web.converter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import ro.ubbcluj.core.model.Administrator;
//import ro.ubbcluj.web.dto.AdministratorDto;
//
//@Component
//public class AdministratorConverter extends AbstractConverterBaseEntityConverter<Administrator, AdministratorDto> {
//    private static final Logger log = LoggerFactory.getLogger(AdministratorConverter.class);
//
//
//    @Override
//    public Administrator convertDtoToModel(AdministratorDto administratorDto) {
//        Administrator administrator = Administrator.builder()
//                .nume(administratorDto.getNume())
//                .build();
//        administrator.setId(administratorDto.getId());
//        return administrator;
//    }
//
//    @Override
//    public AdministratorDto convertModelToDto(Administrator administrator) {
//        AdministratorDto administratorDto = AdministratorDto.builder()
//                .nume(administrator.getNume())
//                .build();
//        administratorDto.setId(administrator.getId());
//        return administratorDto;
//    }
//}
