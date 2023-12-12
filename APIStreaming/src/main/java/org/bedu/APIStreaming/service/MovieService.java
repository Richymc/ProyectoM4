package org.bedu.APIStreaming.service;

import org.bedu.APIStreaming.dto.CreateMovieDTO;
import org.bedu.APIStreaming.dto.MovieDTO;
import org.bedu.APIStreaming.dto.UpdateMovieDTO;
import org.bedu.APIStreaming.exception.MovieNotFoundException;
import org.bedu.APIStreaming.mapper.MovieMapper;
import org.bedu.APIStreaming.model.Movie;
import org.bedu.APIStreaming.repository.MovieRepository;
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

    public void update(long id, UpdateMovieDTO data) throws MovieNotFoundException{
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
