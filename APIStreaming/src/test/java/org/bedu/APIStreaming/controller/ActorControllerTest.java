package org.bedu.APIStreaming.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.bedu.APIStreaming.dto.ActorDTO;
import org.bedu.APIStreaming.dto.CreateActorDTO;
import org.bedu.APIStreaming.service.ActorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ActorControllerTest {

    @MockBean
    private ActorService service;

    @Autowired
    private ActorController controller;

    @Test
    @DisplayName("Controller should be injected")
    void smokeTest(){
        assertNotNull(controller);
    }

    @Test
    @DisplayName("Controller should return a list of actors")
    void findAllTest(){
        List<ActorDTO> data = new LinkedList<>();

        ActorDTO actor = new ActorDTO();

        actor.setId(33);
        actor.setFirstName("Leonardo");
        actor.setLastName("DiCaprio");

        data.add(actor);

        when(service.findAll()).thenReturn(data);

        List<ActorDTO> result = controller.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(actor.getId(), result.get(0).getId());
        assertEquals(actor.getFirstName(), result.get(0).getFirstName());
        assertEquals(actor.getLastName(), result.get(0).getLastName());

    }

    @Test
    @DisplayName("Controller should save an Actor")
    void saveTest(){
        CreateActorDTO dto = new CreateActorDTO();

        dto.setFirstName("Johnny");
        dto.setLastName("Depp");

        ActorDTO actor = new ActorDTO();

        actor.setId(34);
        actor.setFirstName(dto.getFirstName());
        actor.setLastName(dto.getLastName());

        when(service.save(any(CreateActorDTO.class))).thenReturn(actor);

        ActorDTO result = controller.save(dto);

        assertNotNull(result);
        assertEquals(actor.getId(), result.getId());
        assertEquals(actor.getFirstName(), result.getFirstName());
        assertEquals(actor.getLastName(), result.getLastName());
    }

    @Test
    @DisplayName("Controller should update an actor")
    void deleteByIdTest(){
        controller.deleteById(35l);
        verify(service, times(1)).deleteById(35l);
    }

}   
