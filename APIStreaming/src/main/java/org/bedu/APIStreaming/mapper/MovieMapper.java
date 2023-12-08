package org.bedu.APIStreaming.mapper;

import org.bedu.APIStreaming.dto.MovieDTO;
import org.bedu.APIStreaming.model.Movie;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MovieMapper {
    
    MovieDTO toDTO(Movie model);
}
