package org.bedu.service;

import org.bedu.dto.ProfileDTO;
import org.bedu.model.Profile;
import org.bedu.repository.ProfileRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProfileServiceTest {

    @MockBean
    private ProfileRepository repository;

    @Autowired
    private ProfileService service;

    @Test
    @DisplayName("ProfileService should be injected")
    void smokeTest(){
        assertNotNull(service);
    }

    @Test
    @DisplayName("ProfileService should return profiles from repository")
    void findAll(){
        List<Profile> data = new LinkedList();
        Profile profile = new Profile();
        profile.setId(40);
        profile.setName("Panchito");
        data.add(profile);

        when(repository.findAll()).thenReturn(data);
        List<ProfileDTO> result = service.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(profile.getId(), result.get(0).getId());
        assertEquals(profile.getName(), result.get(0).getName());
    }

}
