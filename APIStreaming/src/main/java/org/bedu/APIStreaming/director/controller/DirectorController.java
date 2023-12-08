package org.bedu.APIStreaming.director.controller;

import org.bedu.APIStreaming.director.dto.DirectorDTO;
import org.bedu.APIStreaming.director.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
