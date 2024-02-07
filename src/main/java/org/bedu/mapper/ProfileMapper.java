package org.bedu.mapper;

import org.bedu.dto.CreateProfileDTO;
import org.bedu.dto.ProfileDTO;
import org.bedu.model.Profile;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProfileMapper {

    ProfileDTO toDTO(Profile model);

    List<ProfileDTO> toDTO(List<Profile> model);

    @Mapping(target = "id", ignore = true)
    Profile toModel(CreateProfileDTO dto);

    @Mapping(target = "id")
    Profile toModel(ProfileDTO dto);

}
