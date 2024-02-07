package org.bedu.service;

import org.bedu.repository.ProfileRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
