package org.bedu.APIStreaming.user.service;

import org.bedu.APIStreaming.user.dto.UserDTO;
import org.bedu.APIStreaming.user.mapper.UserMapper;
import org.bedu.APIStreaming.user.repository.UserRepository;
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



}