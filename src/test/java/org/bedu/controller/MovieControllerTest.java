package org.bedu.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.bedu.dto.CreateMovieDTO;
import org.bedu.dto.MovieDTO;
import org.bedu.dto.UpdateMovieDTO;
import org.bedu.exception.MovieNotFoundException;
import org.bedu.service.MovieService;
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

    @Test
    @DisplayName("Controller should save a movie")
    void saveTest(){
        CreateMovieDTO dto = new CreateMovieDTO();

        dto.setName("Elementos");
        dto.setDuration(102);
        dto.setDescription("En una ciudad en la que los elementos de fuego, agua, tierra y aire viven en distritos separados, una chica de fuego y un chico de agua descubren que, aunque la sociedad les diga lo contrario, tienen muchas cosas en común.");
        dto.setGenre("Romance,Fantasia");

        MovieDTO movie = new MovieDTO();

        movie.setId(69);
        movie.setName(dto.getName());
        movie.setDuration(dto.getDuration());
        movie.setDescription(dto.getDescription());
        movie.setGenre(dto.getGenre());

        when(service.save(any(CreateMovieDTO.class))).thenReturn(movie);

        MovieDTO result = controller.save(dto);

        assertNotNull(result);
        assertEquals(movie.getId(), result.getId());
        assertEquals(movie.getName(), result.getName());
        assertEquals(movie.getDuration(), result.getDuration());
        assertEquals(movie.getDescription(), result.getDescription());
        assertEquals(movie.getGenre(), result.getGenre());
    }

    @Test
    @DisplayName("Controller should update a movie")
    void updateTest() throws MovieNotFoundException{
        
        UpdateMovieDTO dto = new UpdateMovieDTO();

        dto.setName("Guardianes de la galaxia vol 3");
        dto.setDuration(149);
        dto.setDescription("Aunque sigue afectado por la pérdida de Gamora, Peter Quill debe reunir a su equipo para defender el universo de una nueva amenaza o, en caso de fracasar, será el final de los Guardianes.");
        dto.setGenre("Accion, Ciencia Ficcion");
        
        controller.update(99, dto);

        verify(service, times(1)).update(99, dto);
    }

    @Test
    @DisplayName("Controller should delete a movie")
    void deleteByIdTest(){
        controller.deleteById(44l);
        verify(service, times(1)).deleteById(44l);
    }
}
