package org.bedu.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.bedu.dto.MovieDTO;
import org.bedu.model.Movie;
import org.bedu.repository.MovieRepository;

import java.util.List;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MovieControllerE2ETest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
    repository.deleteAll();
    }

    //Peticion tipo GET
    @Test
    @DisplayName("GET / movies should return an empty list")
    void emptyListTest() throws Exception{

        MvcResult result = mockMvc.perform(get("/movies"))
            .andExpect(status().isOk())
            .andReturn();

        String content = result.getResponse().getContentAsString();

        assertEquals("[]", content);
    }

    
    @Test
    @DisplayName("GET /movies should return a list of movies")
    void findAllTest() throws Exception{
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();

        movie1.setName("Elementos");
        movie1.setDuration(120);
        movie1.setDescription("Elementos que se enamoran");
        movie1.setGenre("Animacion");

        movie2.setName("Interestelar");
        movie2.setDuration(121);
        movie2.setDescription("Un grupo de cientificos viajan al espacio");
        movie2.setGenre("Ciencia Ficcion");
        

        repository.save(movie1);
        repository.save(movie2);

        MvcResult result = mockMvc.perform(get("/movies"))
        .andExpect(status().isOk())
        .andReturn();

        String content = result.getResponse().getContentAsString();

        TypeReference<List<MovieDTO>> listTypeReference = new TypeReference<List<MovieDTO>>() {};

        List<MovieDTO> response = mapper.readValue(content, listTypeReference);
        
        assertTrue(response.size() == 2);
        assertEquals(movie1.getName(), response.get(0).getName());
        assertEquals(movie2.getName(), response.get(1).getName());
    }

    //Genre mising
    @Test
    @DisplayName("POST /movies should return an error if genre is missing")
    void genreMissingInRequestBodyTest() throws Exception{
        MvcResult result = mockMvc.perform(post("/movies").contentType("application/json").content("{\"name\":\"LEO\",\"duration\":120,\"description\":\"Es una pelicula de un lagarto que piensa que se va a morir\"}"))
            .andExpect(status().isBadRequest())
            .andReturn();

        String content = result.getResponse().getContentAsString();

        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"Por favor ingrese un genero de pelicula\"]}";
        assertEquals(expectedResponse, content);
    }

    //name missing
    @Test
    @DisplayName("POST /movies should return an error if name is missing")
    void nameMissingInRequestBodyTest() throws Exception{
        MvcResult result = mockMvc.perform(post("/movies").contentType("application/json").content("{\"genre\":\"Animacion\",\"duration\":120,\"description\":\"Es una pelicula de un lagarto que piensa que se va a morir\"}"))
            .andExpect(status().isBadRequest())
            .andReturn();

        String content = result.getResponse().getContentAsString();

        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"Por favor ingresar el nombre de la pelicula\"]}";
        assertEquals(expectedResponse, content);
    }

    //duration missing
    @Test
    @DisplayName("POST /movies should return an error if duration is missing")
    void durationMissingInRequestBodyTest() throws Exception{
        MvcResult result = mockMvc.perform(post("/movies").contentType("application/json").content("{\"genre\":\"Animacion\",\"name\":\"LEO\",\"description\":\"Es una pelicula de un lagarto que piensa que se va a morir\"}"))
            .andExpect(status().isBadRequest())
            .andReturn();

        String content = result.getResponse().getContentAsString();

        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"must be greater than 0\"]}";
        assertEquals(expectedResponse, content);
    }
}
