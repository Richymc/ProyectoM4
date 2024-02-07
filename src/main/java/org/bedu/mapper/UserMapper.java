package org.bedu.mapper;

import org.bedu.dto.UserDTO;
import org.bedu.model.User;
import org.bedu.dto.CreateUserDTO;
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

    @Mapping(target = "id")
    User toModel(UserDTO dto);

}