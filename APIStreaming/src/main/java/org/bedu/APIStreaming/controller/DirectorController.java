package org.bedu.APIStreaming.controller;

import jakarta.validation.Valid;
import org.bedu.APIStreaming.dto.CreateDirectorDTO;
import org.bedu.APIStreaming.dto.DirectorDTO;
import org.bedu.APIStreaming.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("directors")
public class DirectorController {

    @Autowired
    DirectorService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DirectorDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public List<DirectorDTO> findByName(@RequestParam String name){
        List<DirectorDTO> directors = new ArrayList<DirectorDTO>();
        directors.addAll(service.findByFirstName(name));
        directors.addAll(service.findByLastName(name));
        return directors;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DirectorDTO save(@Valid @RequestBody CreateDirectorDTO data){
        return service.save(data);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public DirectorDTO update(@RequestBody DirectorDTO data){
        return service.update(data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        service.deleteById(id);
    }

}
