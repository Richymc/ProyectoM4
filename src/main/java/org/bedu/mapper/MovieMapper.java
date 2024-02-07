package org.bedu.mapper;

import java.util.List;

import org.bedu.dto.ActorDTO;
import org.bedu.dto.CreateMovieDTO;
import org.bedu.dto.MovieDTO;
import org.bedu.dto.UpdateMovieDTO;
import org.bedu.model.Actor;
import org.bedu.model.Movie;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MovieMapper {
    
    MovieDTO toDTO(Movie movie);

    ActorDTO toDTO(Actor actor);

    List<MovieDTO> toDTO(List<Movie> movies);
    List<ActorDTO> toDTOActor(List<Actor> actors);



    @Mapping(target = "id", ignore = true)
    Movie toModel(CreateMovieDTO dto);

    @Mapping(target = "id")
    Movie toModel(MovieDTO dto);
    
    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Movie model, UpdateMovieDTO dto);
}
