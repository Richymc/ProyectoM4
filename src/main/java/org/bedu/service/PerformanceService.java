package org.bedu.service;

import org.bedu.dto.ActorDTO;
import org.bedu.dto.MovieDTO;
import org.bedu.mapper.MovieMapper;
import org.bedu.mapper.PerformanceMapper;
import org.bedu.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {
    @Autowired
    private PerformanceRepository repository;

    @Autowired
    private PerformanceMapper mapper;

    @Autowired
    private MovieMapper movieMapper;

    public void addMovie(long actorId, long movieId) {
        repository.save(mapper.toModel(actorId, movieId));
    }

    public List<MovieDTO> findMoviesByActor(long actorId) {
        return movieMapper.toDTO(repository.findMoviesByActor(actorId));
    }

    public List<ActorDTO> findActorsByMovie(long movieId) {
        return movieMapper.toDTOActor(repository.findActorsByMovie(movieId));
    }
}
