package org.bedu.service;

import org.bedu.dto.CreateMovieDTO;
import org.bedu.dto.MovieDTO;
import org.bedu.dto.UpdateMovieDTO;
import org.bedu.exception.MovieNotFoundException;
import org.bedu.mapper.MovieMapper;
import org.bedu.model.Movie;
import org.bedu.repository.MovieRepository;
import java.util.List;
import java.util.Optional;

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

    public MovieDTO save(CreateMovieDTO data){
        Movie entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

    public void update(long id, UpdateMovieDTO data) throws MovieNotFoundException {
        Optional<Movie> result = repository.findById(id);

        if(result.isEmpty()){
            throw new MovieNotFoundException(id);
        }

        Movie model = result.get();

        mapper.update(model, data);

        repository.save(model);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
