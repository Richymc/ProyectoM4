package org.bedu.controller;

import jakarta.validation.Valid;
import org.bedu.dto.ActorDTO;
import org.bedu.dto.AddMovieDTO;
import org.bedu.dto.CreateActorDTO;
import org.bedu.dto.MovieDTO;
import org.bedu.service.ActorService;
import org.bedu.service.PerformanceService;
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

    @Autowired
    private PerformanceService performanceService;

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
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }


    @Operation(summary = "Asocia una pelicula a un actor")
    @PostMapping("{actorId}/movies")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addMovie(@PathVariable long actorId, @RequestBody AddMovieDTO data) {
        performanceService.addMovie(actorId, data.getMovieId());
    }

    @Operation(summary = "Obtiene las peliculas de un actor determinado")
    @GetMapping("{actorId}/movies")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> findMoviesByActor(@PathVariable long actorId) {
        return performanceService.findMoviesByActor(actorId);
    }
}
