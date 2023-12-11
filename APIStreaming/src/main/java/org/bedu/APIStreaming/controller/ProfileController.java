package org.bedu.APIStreaming.controller;

import jakarta.validation.Valid;
import org.bedu.APIStreaming.dto.CreateProfileDTO;
import org.bedu.APIStreaming.dto.ProfileDTO;
import org.bedu.APIStreaming.mapper.ProfileMapper;
import org.bedu.APIStreaming.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoints del Perfil", description = "CRUD del Perfil")
@RestController
@RequestMapping("profiles")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @Autowired
    private ProfileMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileDTO save(@Valid @RequestBody CreateProfileDTO data){
        return service.save(data);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ProfileDTO update(@RequestBody ProfileDTO data){
        return service.update(data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

}
