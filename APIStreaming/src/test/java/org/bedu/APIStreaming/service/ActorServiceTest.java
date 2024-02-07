package org.bedu.APIStreaming.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.bedu.APIStreaming.repository.ActorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ActorServiceTest {

    @MockBean
    private ActorRepository repository;

    @Autowired
    private ActorService service;

    @Test
    @DisplayName("Service should be injected")
    void smokeTest(){
        assertNotNull(service);
    }
    
}
