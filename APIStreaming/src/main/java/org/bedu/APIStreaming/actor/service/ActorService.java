package org.bedu.APIStreaming.actor.service;

import org.bedu.APIStreaming.actor.dto.ActorDTO;
import org.bedu.APIStreaming.actor.dto.CreateActorDTO;
import org.bedu.APIStreaming.actor.mapper.ActorMapper;
import org.bedu.APIStreaming.actor.model.Actor;
import org.bedu.APIStreaming.actor.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    @Autowired
    private ActorRepository repository;

    @Autowired
    private ActorMapper mapper;

    public ActorDTO save(CreateActorDTO data){
        Actor entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }
}
