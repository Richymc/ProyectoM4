package org.bedu.APIStreaming.director.mapper;

import org.bedu.APIStreaming.director.model.Director;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DirectorMapper {

    DirectorDTO toDTO(Director model);
    List<DirectorDTO> toDTO(List<Director> model);

    @Mapping(target = "id", ignore = true)
    Director toModel(CreateDirectorDTO dto);

    @Mapping(target = "id")
    Director toModel(DirectorDTO dto);

}
