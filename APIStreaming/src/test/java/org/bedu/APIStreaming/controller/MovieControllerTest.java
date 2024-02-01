package org.bedu.APIStreaming.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.bedu.APIStreaming.dto.MovieDTO;
import org.bedu.APIStreaming.service.MovieService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MovieControllerTest {
    
    @MockBean
    private MovieService service;

    @Autowired
    private MovieController controller;

    @Test
    @DisplayName("Controller should be injected")
    void smokeTest(){
        assertNotNull(controller);
    }

    @Test
    @DisplayName("Controller should return a list of movies")
    void findAllTest(){
        List<MovieDTO> data = new LinkedList<>();

        MovieDTO movie = new MovieDTO();

        movie.setId(32);
        movie.setName("LEO");
        movie.setDuration(102);
        movie.setDescription("Leo el Lagarto lleva décadas atrapado en la misma escuela de Florida. Cuando se entera de que sólo le queda un año de vida, planea escapar a la libertad, pero en su lugar tiene que rescatar a su clase de su horriblemente malvado profesor sustituto.");
        movie.setGenre("Animacion");

        data.add(movie);

        when(service.findAll()).thenReturn(data);

        List<MovieDTO> result = controller.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(movie.getId(), result.get(0).getId());
        assertEquals(movie.getName(),result.get(0).getName());
        assertEquals(movie.getDuration(),result.get(0).getDuration());
        assertEquals(movie.getDescription(),result.get(0).getDescription());
        assertEquals(movie.getGenre(), result.get(0).getGenre());
    }

}
