package org.bedu.controller;

import jakarta.validation.Valid;
import org.bedu.dto.CreateProfileDTO;
import org.bedu.dto.ProfileDTO;
import org.bedu.mapper.ProfileMapper;
import org.bedu.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoints del Perfil", description = "CRUD del Perfil")
@RestController
@RequestMapping("profiles")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @Autowired
    private ProfileMapper mapper;

    @Operation(summary = "Obtiene una lista con todos los Perfiles")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Crea un nuevo Perfil")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileDTO save(@Valid @RequestBody CreateProfileDTO data){
        return service.save(data);
    }

    @Operation(summary = "Actualiza la información de un Perfil")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ProfileDTO update(@RequestBody ProfileDTO data){
        return service.update(data);
    }

    @Operation(summary = "Elimina un perfil")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

}
