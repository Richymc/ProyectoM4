package org.bedu.service;

import org.bedu.dto.CreateDirectorDTO;
import org.bedu.dto.DirectorDTO;
import org.bedu.mapper.DirectorMapper;
import org.bedu.model.Director;
import org.bedu.repository.DirectorRepository;
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

    public List<DirectorDTO> findByFirstName(String firstName){
        return repository.findByFirstName(firstName).stream().map(mapper::toDTO).toList();
    }

    public List<DirectorDTO> findByLastName(String lastName){
        return repository.findByLastName(lastName).stream().map(mapper::toDTO).toList();
    }

    public DirectorDTO save(CreateDirectorDTO data){
        Director entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

    public DirectorDTO update(DirectorDTO data){
        return mapper.toDTO(repository.save(mapper.toModel(data)));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
