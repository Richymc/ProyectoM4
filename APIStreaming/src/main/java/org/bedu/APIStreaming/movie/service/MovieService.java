package org.bedu.APIStreaming.movie.service;

import org.bedu.APIStreaming.movie.dto.MovieDTO;
import org.bedu.APIStreaming.movie.mapper.MovieMapper;
import org.bedu.APIStreaming.movie.repository.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository repository;

    @Autowired
    private MovieMapper mapper;

    public List<MovieDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
}
