package org.bedu.service;

import org.bedu.dto.ActorDTO;
import org.bedu.dto.CreateActorDTO;
import org.bedu.mapper.ActorMapper;
import org.bedu.model.Actor;
import org.bedu.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository repository;

    @Autowired
    private ActorMapper mapper;

    public List<ActorDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public List<ActorDTO> findByFirstName(String firstName){
        return repository.findByFirstName(firstName).stream().map(mapper::toDTO).toList();
    }

    public List<ActorDTO> findByLastName(String lastName){
        return repository.findByLastName(lastName).stream().map(mapper::toDTO).toList();
    }

    public ActorDTO save(CreateActorDTO data){
        Actor entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

    public ActorDTO update(ActorDTO data){
        return mapper.toDTO(repository.save(mapper.toModel(data)));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
