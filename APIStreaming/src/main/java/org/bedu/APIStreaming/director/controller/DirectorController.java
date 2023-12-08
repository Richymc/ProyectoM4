package org.bedu.APIStreaming.director.controller;

import org.bedu.APIStreaming.director.dto.DirectorDTO;
import org.bedu.APIStreaming.director.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

}
