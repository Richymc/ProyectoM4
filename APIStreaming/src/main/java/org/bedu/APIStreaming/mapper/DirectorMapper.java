package org.bedu.APIStreaming.mapper;

import org.bedu.APIStreaming.dto.CreateDirectorDTO;
import org.bedu.APIStreaming.dto.DirectorDTO;
import org.bedu.APIStreaming.model.Director;
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
