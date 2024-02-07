package org.bedu.mapper;

import org.bedu.dto.CreateDirectorDTO;
import org.bedu.dto.DirectorDTO;
import org.bedu.model.Director;
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
