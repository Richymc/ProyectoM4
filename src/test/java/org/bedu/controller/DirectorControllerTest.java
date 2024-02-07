package org.bedu.controller;

import org.bedu.dto.DirectorDTO;
import org.bedu.service.DirectorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.LinkedList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DirectorControllerTest {

    @MockBean
    private DirectorService service;

    @Autowired
    private DirectorController controller;

    @Test
    @DisplayName("DirectorController should be injected")
    void smokeTest(){
        assertNotNull(controller);
    }

    @Test
    @DisplayName("DirectorController should return a list of directors")
    void findAllTest(){
        List<DirectorDTO> data = new LinkedList<>();
        DirectorDTO director = new DirectorDTO();
        director.setId(88);
        director.setFirstName("Woody");
        director.setLastName("Allen");
        data.add(director);

        when(service.findAll()).thenReturn(data);
        List<DirectorDTO> result = controller.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(director.getId(), result.get(0).getId());
        assertEquals(director.getFirstName(), result.get(0).getFirstName());
        assertEquals(director.getLastName(), result.get(0).getLastName());
    }

    @Test
    @DisplayName("DirectorController should delete a director")
    void deleteTest(){
        controller.delete(20l);
        verify(service, times(1)).deleteById(20l);
    }
}
