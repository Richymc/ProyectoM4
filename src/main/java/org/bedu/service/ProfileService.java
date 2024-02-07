package org.bedu.service;

import org.bedu.dto.CreateProfileDTO;
import org.bedu.dto.ProfileDTO;
import org.bedu.mapper.ProfileMapper;
import org.bedu.model.Profile;
import org.bedu.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    @Autowired
    private ProfileMapper mapper;

    public List<ProfileDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public ProfileDTO save(CreateProfileDTO data){
        Profile entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

    public ProfileDTO update(ProfileDTO data){
        return mapper.toDTO(repository.save(mapper.toModel(data)));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
