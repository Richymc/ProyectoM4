package org.bedu.controller;

import java.util.List;

import org.bedu.dto.ActorDTO;
import org.bedu.dto.CreateMovieDTO;
import org.bedu.dto.MovieDTO;
import org.bedu.dto.UpdateMovieDTO;
import org.bedu.exception.MovieNotFoundException;
import org.bedu.service.DirectingService;
import org.bedu.service.MovieService;
import org.bedu.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

@Tag(name = "Endpoints de Películas", description = "CRUD de Películas")
@RestController
@RequestMapping("movies")
public class MovieController {
    
    @Autowired
    private MovieService service;

    @Autowired
    private DirectingService directingService;

    @Autowired
    private PerformanceService performanceService;

    @Operation(summary = "Obtiene una lista con todas las peliculas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Crea una nueva película")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO save(@Valid @RequestBody CreateMovieDTO data){
        return service.save(data);
    }

    @Operation(summary = "Actualiza una pelicula")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @Valid @RequestBody UpdateMovieDTO data) throws MovieNotFoundException {
        service.update(id, data);
    }

    @Operation(summary = "Elimina una pelicula")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }


    @Operation(summary = "Obtiene los actores de una película determinada")
    @GetMapping("{movieId}/actors")
    @ResponseStatus(HttpStatus.OK)
    public List<ActorDTO> findActorsByMovie(@PathVariable long movieId) {
        return performanceService.findActorsByMovie(movieId);
    }

}
