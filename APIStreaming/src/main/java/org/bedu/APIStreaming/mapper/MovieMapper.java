package org.bedu.APIStreaming.mapper;

import java.util.List;

import org.bedu.APIStreaming.dto.CreateMovieDTO;
import org.bedu.APIStreaming.dto.MovieDTO;
import org.bedu.APIStreaming.dto.UpdateMovieDTO;
import org.bedu.APIStreaming.model.Movie;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MovieMapper {
    
    MovieDTO toDTO(Movie model);

    List<MovieDTO> toDTO(List<Movie> model);

    @Mapping(target = "id", ignore = true)
    Movie toModel(CreateMovieDTO dto);

    @Mapping(target = "id")
    Movie toModel(MovieDTO dto);
    
    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Movie model, UpdateMovieDTO dto);
}
