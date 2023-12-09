package org.bedu.APIStreaming.controller;

import jakarta.validation.Valid;
import org.bedu.APIStreaming.dto.CreateUserDTO;
import org.bedu.APIStreaming.dto.UserDTO;
import org.bedu.APIStreaming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Endpoints de Usuarios", description = "CRUD de Usuarios")
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService service;

    @Operation(summary = "Obtiene una lista con todos los Usuarios")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Crea un nuevo Usuario")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@Valid @RequestBody CreateUserDTO data) {
        return service.save(data);
    }

}