package org.bedu.APIStreaming.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.bedu.APIStreaming.dto.ActorDTO;
import org.bedu.APIStreaming.dto.CreateActorDTO;
import org.bedu.APIStreaming.model.Actor;
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

    @Test
    @DisplayName("Service should return actors from repository")
    void findAll(){
        List<Actor> data = new LinkedList();

        Actor actor = new Actor();

        actor.setId(40);
        actor.setFirstName("Bred");
        actor.setLastName("Pitt");

        data.add(actor);

        when(repository.findAll()).thenReturn(data);

        List<ActorDTO> result = service.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(actor.getId(), result.get(0).getId());
        assertEquals(actor.getFirstName(), result.get(0).getFirstName());
        assertEquals(actor.getLastName(), result.get(0).getLastName());
    }
    
    @Test
    @DisplayName("Service should save an actor in repository")
    void saveTest(){
        CreateActorDTO dto = new CreateActorDTO();

        dto.setFirstName("Denzel");
        dto.setLastName("Washington");

        Actor model = new Actor();

        model.setId(55);
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());

        when(repository.save(any(Actor.class))).thenReturn(model);

        ActorDTO result = service.save(dto);

        assertNotNull(result);
        assertEquals(model.getId(), result.getId());
        assertEquals(model.getFirstName(), result.getFirstName());
        assertEquals(model.getLastName(), result.getLastName());
    }
}
