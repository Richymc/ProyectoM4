package org.bedu.APIStreaming.controller;

import java.util.List;

import org.bedu.APIStreaming.dto.CreateMovieDTO;
import org.bedu.APIStreaming.dto.MovieDTO;
import org.bedu.APIStreaming.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Operation(summary = "Obtiene una lista con todas las peliculas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO save(@Valid @RequestBody CreateMovieDTO data){
        return service.save(data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

}
