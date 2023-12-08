package org.bedu.APIStreaming.movie.service;

import org.bedu.APIStreaming.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository respository;

    
}
