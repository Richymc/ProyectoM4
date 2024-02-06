package org.bedu.APIStreaming.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.bedu.APIStreaming.dto.MovieDTO;
import org.bedu.APIStreaming.model.Movie;
import org.bedu.APIStreaming.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import java.util.LinkedList;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MovieServiceTest {
    
    @MockBean
    private MovieRepository repository;

    @Autowired
    private MovieService service;

    @Test
    @DisplayName("Service should be injected")
    void smokeTest(){
        assertNotNull(service);
    }

    @Test
    @DisplayName("Service should return movies from repository")
    void findAllTest(){

        List<Movie> data = new LinkedList();

        Movie movie = new Movie();

        movie.setId(77);
        movie.setName("Cuestion de tiempo");
        movie.setDuration(123);
        movie.setDescription("Cuando Tim Lake cumple 21 años, su padre le dice un secreto: los hombres de su familia pueden viajar por el tiempo. A pesar de que él no puede cambiar la historia, Tim decide mejorar su vida buscando una novia. Él conoce a Mary, se enamora y finalmente se gana su corazón con los viajes en el tiempo y un poco de astucia. Sin embargo, mientras su inusual vida progresa, Tim descubre que su habilidad especial no puede protegerlos de los problemas diarios de la vida.");
        movie.setGenre("Romance,Ciencia Ficcion");

        data.add(movie);

        when(repository.findAll()).thenReturn(data);

        List<MovieDTO> result = service.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(movie.getId(), result.get(0).getId());
        assertEquals(movie.getName(), result.get(0).getName());
        assertEquals(movie.getDuration(), result.get(0).getDuration());
        assertEquals(movie.getDescription(), result.get(0).getDescription());
        assertEquals(movie.getGenre(), result.get(0).getGenre());

    }
}
