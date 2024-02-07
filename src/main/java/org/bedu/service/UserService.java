package org.bedu.service;

import org.bedu.dto.CreateUserDTO;
import org.bedu.dto.UserDTO;
import org.bedu.mapper.UserMapper;
import org.bedu.model.User;
import org.bedu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public List<UserDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public List<UserDTO> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName).stream().map(mapper::toDTO).toList();
    }

    public List<UserDTO> findByLastName(String lastName){
        return repository.findByLastName(lastName).stream().map(mapper::toDTO).toList();
    }

    public UserDTO save(CreateUserDTO data) {
        User entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

    public UserDTO update(UserDTO data){
        return mapper.toDTO(repository.save(mapper.toModel(data)));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}