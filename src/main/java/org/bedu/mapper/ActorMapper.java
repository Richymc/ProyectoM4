package org.bedu.mapper;

import org.bedu.dto.ActorDTO;
import org.bedu.dto.CreateActorDTO;
import org.bedu.model.Actor;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ActorMapper {

    ActorDTO toDTO(Actor model);
    List<ActorDTO> toDTO(List<Actor> model);

    @Mapping(target = "id", ignore = true)
    Actor toModel(CreateActorDTO dto);

    @Mapping(target = "id")
    Actor toModel(ActorDTO dto);

}
