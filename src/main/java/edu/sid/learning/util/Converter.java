package edu.sid.learning.util;

import java.util.Collection;
import java.util.function.Function;

public class Converter<D, E> {

    private final Function<D, E> fromDto;
    private final Function<E, D> fromEntity;

    public Converter(Function<D, E> fromDto, Function<E, D> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public E fromDto(D dto) {
        return fromDto.apply(dto);
    }

    public D fromEntity(E entity) {
        return fromEntity.apply(entity);
    }

    public Collection<E> fromDto(Collection<D> dtos) {
        return dtos.stream().map(fromDto).toList();
    }

    public Collection<D> fromEntity(Collection<E> entities) {
        return entities.stream().map(fromEntity).toList();
    }
}