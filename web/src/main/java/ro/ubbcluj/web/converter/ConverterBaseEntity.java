package ro.ubbcluj.web.converter;

import ro.ubbcluj.core.model.BaseEntity;
import ro.ubbcluj.web.dto.BaseDto;

public interface ConverterBaseEntity<Model extends BaseEntity<Long>, Dto extends BaseDto>
        extends Converter<Model, Dto> {

}
