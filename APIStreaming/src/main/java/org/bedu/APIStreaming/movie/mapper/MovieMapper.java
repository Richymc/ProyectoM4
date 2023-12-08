package org.bedu.APIStreaming.movie.mapper;

import org.bedu.APIStreaming.movie.dto.MovieDTO;
import org.bedu.APIStreaming.movie.model.Movie;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MovieMapper {
    
    MovieDTO toDTO(Movie model);
}
