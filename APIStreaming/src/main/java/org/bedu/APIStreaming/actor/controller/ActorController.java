package org.bedu.APIStreaming.actor.controller;

import org.bedu.APIStreaming.actor.dto.ActorDTO;
import org.bedu.APIStreaming.actor.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

}
