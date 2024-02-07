package org.bedu.APIStreaming.controller;

import org.bedu.APIStreaming.dto.UserDTO;
import org.bedu.APIStreaming.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserControllerTest {

    @MockBean
    private UserService service;

    @Autowired
    private UserController controller;

    @Test
    @DisplayName("UserController should be injected")
    void smokeTest(){
        assertNotNull(controller);
    }

    @Test
    @DisplayName("UserController should return a list of users")
    void findAllTest(){
        List<UserDTO> data = new LinkedList<>();
        UserDTO user = new UserDTO();
        user.setId(29);
        user.setFirstName("Juan");
        user.setLastName("Jalisco");
        data.add(user);

        when(service.findAll()).thenReturn(data);
        List<UserDTO> result = controller.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(user.getId(), result.get(0).getId());
        assertEquals(user.getFirstName(), result.get(0).getFirstName());
        assertEquals(user.getLastName(), result.get(0).getLastName());
    }

}
