package org.bedu.APIStreaming.service;

import org.bedu.APIStreaming.dto.ActorDTO;
import org.bedu.APIStreaming.dto.MovieDTO;
import org.bedu.APIStreaming.mapper.MovieMapper;
import org.bedu.APIStreaming.mapper.PerformanceMapper;
import org.bedu.APIStreaming.model.Performance;
import org.bedu.APIStreaming.repository.PerformanceRepository;
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
