package org.bedu.controller;

import jakarta.validation.Valid;
import org.bedu.dto.AddMovieDTO;
import org.bedu.dto.CreateDirectorDTO;
import org.bedu.dto.DirectorDTO;
import org.bedu.dto.MovieDTO;
import org.bedu.service.DirectingService;
import org.bedu.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Endpoints de Directores", description = "CRUD de Directores")
@RestController
@RequestMapping("directors")
public class DirectorController {

    @Autowired
    DirectorService service;

    @Autowired
    private DirectingService directingService;

    @Operation(summary = "Obtiene una lista con todos los Directores")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DirectorDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Aplica un filtro y regresa una lista con todos las concidencias de los Directores")
    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public List<DirectorDTO> findByName(@RequestParam String name){
        List<DirectorDTO> directors = new ArrayList<DirectorDTO>();
        directors.addAll(service.findByFirstName(name));
        directors.addAll(service.findByLastName(name));
        return directors;
    }

    @Operation(summary = "Crea un nuevo Director")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DirectorDTO save(@Valid @RequestBody CreateDirectorDTO data){
        return service.save(data);
    }

    @Operation(summary = "Actualiza la información de un Director")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public DirectorDTO update(@RequestBody DirectorDTO data){
        return service.update(data);
    }

    @Operation(summary = "Elimina un Director")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

    @Operation(summary = "Asocia una pelicula a un director")
    @PostMapping("{directorId}/movies")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addMovie(@PathVariable long directorId, @RequestBody AddMovieDTO data) {
        directingService.addMovie(directorId, data.getMovieId());
    }

    @Operation(summary = "Obtiene las peliculas de un director determinado")
    @GetMapping("{directorId}/movies")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> findMoviesByDirector(@PathVariable long directorId) {
        return directingService.findMoviesByDirector(directorId);
    }
}
