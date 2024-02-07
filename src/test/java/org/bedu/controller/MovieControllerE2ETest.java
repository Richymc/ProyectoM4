package org.bedu.controller;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MovieControllerE2ETest {
    
    @Autowired
    private MockMvc mockMvc;

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

    //Genre mising
    @Test
    @DisplayName("POST /movies should return an error if title is genre is missing")
    void genreMissingInRequestBodyTest() throws Exception{
        MvcResult result = mockMvc.perform(post("/movies").contentType("application/json").content("{\"name\":\"LEO\",\"duration\":120,\"description\":\"Es una pelicula de un lagarto que piensa que se va a morir\"}"))
            .andExpect(status().isBadRequest())
            .andReturn();

        String content = result.getResponse().getContentAsString();

        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"Por favor ingrese un genero de pelicula\"]}";
        assertEquals(expectedResponse, content);
    }
}
