package org.bedu.APIStreaming.user.mapper;

import org.bedu.APIStreaming.user.dto.UserDTO;
import org.bedu.APIStreaming.user.model.User;
import org.bedu.APIStreaming.user.dto.CreateUserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDTO toDTO(User model);

    @Mapping(target = "id", ignore = true)
    User toModel(CreateUserDTO dto);
}