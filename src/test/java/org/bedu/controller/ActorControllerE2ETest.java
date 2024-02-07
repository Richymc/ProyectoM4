package org.bedu.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.bedu.dto.ActorDTO;
import org.bedu.model.Actor;
import org.bedu.repository.ActorRepository;
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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ActorControllerE2ETest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ActorRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
    repository.deleteAll();
    }

    //Peticion tipo GET
    @Test
    @DisplayName("GET / actors should return an empty list")
    void emptyListTest() throws Exception{

        MvcResult result = mockMvc.perform(get("/actors"))
            .andExpect(status().isOk())
            .andReturn();

        String content = result.getResponse().getContentAsString();

        assertEquals("[]", content);
    }

    //Regresa lista de actores
    @Test
    @DisplayName("GET /actors should return a list of actors")
    void findAllTest() throws Exception{
        Actor actor1 = new Actor();
        Actor actor2 = new Actor();

        actor1.setFirstName("Leonardo");
        actor1.setLastName("DiCaprio");

        actor2.setFirstName("Angelina");
        actor2.setLastName("Jolie");

        repository.save(actor1);
        repository.save(actor2);

        MvcResult result = mockMvc.perform(get("/actors"))
        .andExpect(status().isOk())
        .andReturn();

        String content = result.getResponse().getContentAsString();

        TypeReference<List<ActorDTO>> listTypeReference = new TypeReference<List<ActorDTO>>(){};
    
        List<ActorDTO> response = mapper.readValue(content, listTypeReference);
        
        assertTrue(response.size() == 2);
        assertEquals(actor1.getFirstName(), response.get(0).getFirstName());
        assertEquals(actor2.getLastName(), response.get(1).getLastName());
    
    }
    
    //First Name missing
    @Test
    @DisplayName("POST / actors should return an error if FirstName is missing")
    void firstNameMissingInRequestbodyTest() throws Exception{

        MvcResult result = mockMvc.perform(post("/actors").contentType("application/json").content("{\"lastName\":\"Stone\"}"))
            .andExpect(status().isBadRequest())
            .andReturn();
            
        String content = result.getResponse().getContentAsString();

        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"Por favor ingresar el nombre del actor\"]}";
        assertEquals(expectedResponse, content);

    }

    //Last Name missing
    @Test
    @DisplayName("POST / actors should return an error if LastName is missing")
    void lastNameMissingInRequestbodyTest() throws Exception{

        MvcResult result = mockMvc.perform(post("/actors").contentType("application/json").content("{\"firstName\":\"Emma\"}"))
            .andExpect(status().isBadRequest())
            .andReturn();
            
        String content = result.getResponse().getContentAsString();

        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"Por favor ingresar el apellido del actor\"]}";
        assertEquals(expectedResponse, content);

    }
}
