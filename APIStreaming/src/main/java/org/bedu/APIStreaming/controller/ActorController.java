package org.bedu.APIStreaming.controller;

import jakarta.validation.Valid;
import org.bedu.APIStreaming.dto.ActorDTO;
import org.bedu.APIStreaming.dto.CreateActorDTO;
import org.bedu.APIStreaming.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ActorDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<ActorDTO> findByName(@RequestParam String name){
        ArrayList<ActorDTO> actors = new ArrayList<ActorDTO>();
        actors.addAll(service.findByFirstName(name));
        actors.addAll(service.findByLastName(name));
        return actors;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  ActorDTO save(@Valid @RequestBody CreateActorDTO data){
        return service.save(data);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ActorDTO update(@RequestBody ActorDTO data){
        return service.update(data);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

}
