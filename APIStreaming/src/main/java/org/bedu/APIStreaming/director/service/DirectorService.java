package org.bedu.APIStreaming.director.service;

import org.bedu.APIStreaming.director.dto.CreateDirectorDTO;
import org.bedu.APIStreaming.director.dto.DirectorDTO;
import org.bedu.APIStreaming.director.mapper.DirectorMapper;
import org.bedu.APIStreaming.director.model.Director;
import org.bedu.APIStreaming.director.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository repository;


    @Autowired
    private DirectorMapper mapper;


    public List<DirectorDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public DirectorDTO save(CreateDirectorDTO data){
        Director entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

}
