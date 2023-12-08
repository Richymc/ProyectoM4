package org.bedu.APIStreaming.controller;

import jakarta.validation.Valid;
import org.bedu.APIStreaming.dto.CreateUserDTO;
import org.bedu.APIStreaming.dto.UserDTO;
import org.bedu.APIStreaming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@Valid @RequestBody CreateUserDTO data) {
        return service.save(data);
    }

}