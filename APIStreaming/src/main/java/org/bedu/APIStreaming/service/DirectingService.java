package org.bedu.APIStreaming.service;

import org.bedu.APIStreaming.dto.MovieDTO;
import org.bedu.APIStreaming.mapper.DirectingMapper;
import org.bedu.APIStreaming.mapper.MovieMapper;
import org.bedu.APIStreaming.repository.DirectingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectingService {
    @Autowired
    private DirectingRepository repository;

    @Autowired
    private DirectingMapper mapper;

    @Autowired
    private MovieMapper movieMapper;

    public void addMovie(long directorId, long movieId) {
        repository.save(mapper.toModel(directorId, movieId));
    }

    public List<MovieDTO> findMoviesByDirector(long directorId) {
        return movieMapper.toDTO(repository.findMoviesByDirector(directorId));
    }


}
