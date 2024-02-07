package org.bedu.mapper;

import org.bedu.model.Directing;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DirectingMapper {
    @Mapping(source = "directorId", target = "id.directorId")
    @Mapping(source = "directorId", target = "director.id")
    @Mapping(source = "movieId", target = "id.movieId")
    @Mapping(source = "movieId", target = "movie.id")
    Directing toModel(Long directorId, Long movieId);
}
