package org.bedu.APIStreaming.mapper;

import org.bedu.APIStreaming.dto.UserDTO;
import org.bedu.APIStreaming.model.User;
import org.bedu.APIStreaming.dto.CreateUserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDTO toDTO(User model);
    List<UserDTO> toDTO(List<User> model);

    @Mapping(target = "id", ignore = true)
    User toModel(CreateUserDTO dto);

}