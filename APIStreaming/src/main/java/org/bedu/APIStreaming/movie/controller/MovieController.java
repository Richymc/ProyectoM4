package org.bedu.APIStreaming.movie.controller;

import java.util.List;

import org.bedu.APIStreaming.movie.dto.MovieDTO;
import org.bedu.APIStreaming.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
    
    @Autowired
    private MovieService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> findAll(){
        return service.findAll();
    }

}
