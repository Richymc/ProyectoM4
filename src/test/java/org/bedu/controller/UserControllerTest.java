package org.bedu.controller;

import org.bedu.dto.CreateUserDTO;
import org.bedu.dto.UserDTO;
import org.bedu.service.UserService;
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
import static org.mockito.Mockito.*;


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

    @Test
    @DisplayName("UserController should save a user")
    void saveTest(){
        CreateUserDTO userDTO = new CreateUserDTO();
        userDTO.setFirstName("Raul");
        userDTO.setLastName("Hernandez");

        when(service.save(any(CreateUserDTO.class))).thenReturn(new UserDTO());
        UserDTO dto = service.save(userDTO);
        UserDTO savedUser = controller.save(userDTO);

        assertNotNull(savedUser);
        assertEquals(dto.getFirstName(), savedUser.getFirstName());
        assertEquals(dto.getLastName(), savedUser.getLastName());
    }

    @Test
    @DisplayName("UserController should delete a user")
    void deleteTest(){
        controller.delete(20l);
        verify(service, times(1)).deleteById(20l);
    }

}
