package org.bedu.APIStreaming.mapper;

import org.bedu.APIStreaming.model.Performance;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PerformanceMapper {
    @Mapping(source = "actorId", target = "id.actorId")
    @Mapping(source = "actorId", target = "actor.id")
    @Mapping(source = "movieId", target = "id.movieId")
    @Mapping(source = "movieId", target = "movie.id")
    Performance toModel(Long actorId, Long movieId);
}
