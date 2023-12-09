package org.bedu.APIStreaming.controller;

import jakarta.validation.Valid;
import org.bedu.APIStreaming.dto.ActorDTO;
import org.bedu.APIStreaming.dto.CreateActorDTO;
import org.bedu.APIStreaming.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Endpoints de Actores", description = "CRUD de Actores")
@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService service;

    @Operation(summary = "Obtiene una lista con todos los Actores")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ActorDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Aplica un filtro y regresa una lista con todos las concidencias de los Actores")
    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<ActorDTO> findByName(@RequestParam String name){
        ArrayList<ActorDTO> actors = new ArrayList<ActorDTO>();
        actors.addAll(service.findByFirstName(name));
        actors.addAll(service.findByLastName(name));
        return actors;
    }

    @Operation(summary = "Crea un nuevo Actor")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  ActorDTO save(@Valid @RequestBody CreateActorDTO data){
        return service.save(data);
    }

    @Operation(summary = "Actualiza la información de un Actor")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ActorDTO update(@RequestBody ActorDTO data){
        return service.update(data);
    }


    @Operation(summary = "Elimina un Actor")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

}
