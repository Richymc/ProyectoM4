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

import java.util.ArrayList;
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

    @Operation(summary = "Aplica un filtro y regresa una lista con todos las concidencias de los Usuarios")
    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<UserDTO> findByName(@RequestParam String name){
        ArrayList users = new ArrayList<UserDTO>();
        users.addAll(service.findByFirstName(name));
        users.addAll(service.findByLastName(name));
        return users;
    }

    @Operation(summary = "Crea un nuevo Usuario")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@Valid @RequestBody CreateUserDTO data) {
        return service.save(data);
    }

    @Operation(summary = "Actualiza la información de un Usuario")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@RequestBody UserDTO data){
        return service.update(data);
    }

    @Operation(summary = "Elimina a un Usuario")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }
}