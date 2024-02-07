package org.bedu.controller;

import org.bedu.dto.CreateDirectorDTO;
import org.bedu.dto.CreateProfileDTO;
import org.bedu.dto.DirectorDTO;
import org.bedu.dto.ProfileDTO;
import org.bedu.service.ProfileService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProfileControllerTest {

    @MockBean
    private ProfileService service;

    @Autowired
    private ProfileController controller;

    @Test
    @DisplayName("ProfileController should be injected")
    void smokeTest(){
        assertNotNull(controller);
    }

    @Test
    @DisplayName("ProfileController should return a list of profiles")
    void findAllTest(){
        List<ProfileDTO> data = new LinkedList<>();
        ProfileDTO profile = new ProfileDTO();
        profile.setId(54);
        profile.setName("Alan");
        data.add(profile);

        when(service.findAll()).thenReturn(data);
        List<ProfileDTO> result = controller.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(profile.getId(), result.get(0).getId());
        assertEquals(profile.getName(), result.get(0).getName());
    }

    @Test
    @DisplayName("ProfileController should save a profile")
    void saveTest(){
        CreateProfileDTO profileDTO = new CreateProfileDTO();
        profileDTO.setName("Rafaela");

        when(service.save(any(CreateProfileDTO.class))).thenReturn(new ProfileDTO());
        ProfileDTO dto = service.save(profileDTO);
        ProfileDTO savedProfile = controller.save(profileDTO);

        assertNotNull(savedProfile);
        assertEquals(dto.getName(), savedProfile.getName());
    }

    @Test
    @DisplayName("ProfileController should delete a profile")
    void deleteTest(){
        controller.deleteById(20l);
        verify(service, times(1)).deleteById(20l);
    }
}
