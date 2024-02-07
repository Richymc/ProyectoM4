package org.bedu.service;

import org.bedu.dto.DirectorDTO;
import org.bedu.model.Director;
import org.bedu.repository.DirectorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

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

    @Test
    @DisplayName("DirectorService should return directors from repository")
    void findAll(){
        List<Director> data = new LinkedList();
        Director director = new Director();
        director.setId(88);
        director.setFirstName("Woody");
        director.setLastName("Allen");
        data.add(director);

        when(repository.findAll()).thenReturn(data);
        List<DirectorDTO> result = service.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(director.getId(), result.get(0).getId());
        assertEquals(director.getFirstName(), result.get(0).getFirstName());
        assertEquals(director.getLastName(), result.get(0).getLastName());
    }


}
