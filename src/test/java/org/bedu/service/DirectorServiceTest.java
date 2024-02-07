package org.bedu.service;

import org.bedu.repository.DirectorRepository;
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
public class DirectorServiceTest {

    @MockBean
    private DirectorRepository repository;

    @Autowired
    private DirectorService service;

    @Test
    @DisplayName("DirectorService should be injected")
    void smokeTest(){
        assertNotNull(service);
    }
}
