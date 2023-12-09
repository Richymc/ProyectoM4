package org.bedu.APIStreaming.mapper;

import org.bedu.APIStreaming.dto.CreateMovieDTO;
import org.bedu.APIStreaming.dto.MovieDTO;
import org.bedu.APIStreaming.model.Movie;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MovieMapper {
    
    MovieDTO toDTO(Movie model);

    @Mapping(target = "id", ignore = true)
    Movie toModel(CreateMovieDTO dto);
}
