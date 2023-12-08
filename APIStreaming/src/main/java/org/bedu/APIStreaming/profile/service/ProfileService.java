package org.bedu.APIStreaming.profile.service;

import org.bedu.APIStreaming.profile.dto.CreateProfileDTO;
import org.bedu.APIStreaming.profile.dto.ProfileDTO;
import org.bedu.APIStreaming.profile.mapper.ProfileMapper;
import org.bedu.APIStreaming.profile.model.Profile;
import org.bedu.APIStreaming.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    @Autowired
    private ProfileMapper mapper;

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
