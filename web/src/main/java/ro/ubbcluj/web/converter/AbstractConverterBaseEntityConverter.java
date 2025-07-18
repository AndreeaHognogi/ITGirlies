package ro.ubbcluj.web.converter;

import ro.ubbcluj.core.model.BaseEntity;
import ro.ubbcluj.web.dto.BaseDto;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractConverterBaseEntityConverter <Model extends BaseEntity<Long>, Dto extends BaseDto>
        extends AbstractConverter<Model, Dto> implements ConverterBaseEntity<Model, Dto> {

    public Set<Long> convertModelsToIDs(Set<Model> models) {
        return models.stream()
                .map(BaseEntity::getId)
                .collect(Collectors.toSet());
    }

    public Set<Long> convertDTOsToIDs(Set<Dto> dtos) {
        return dtos.stream()
                .map(BaseDto::getId)
                .collect(Collectors.toSet());
    }

}
