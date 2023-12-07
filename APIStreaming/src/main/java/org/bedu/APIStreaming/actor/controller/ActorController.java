package org.bedu.APIStreaming.actor.controller;

import jakarta.validation.Valid;
import org.bedu.APIStreaming.actor.dto.ActorDTO;
import org.bedu.APIStreaming.actor.dto.CreateActorDTO;
import org.bedu.APIStreaming.actor.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actors")
public class ActorController {

    @Autowired
    private ActorService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ActorDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  ActorDTO save(@Valid @RequestBody CreateActorDTO data){
        return service.save(data);
    }

}
