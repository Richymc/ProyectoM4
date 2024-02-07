package org.bedu.service;

import org.bedu.dto.MovieDTO;
import org.bedu.mapper.DirectingMapper;
import org.bedu.mapper.MovieMapper;
import org.bedu.repository.DirectingRepository;
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
