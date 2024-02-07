package org.bedu.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.bedu.dto.CreateUserDTO;
import org.bedu.dto.UserDTO;
import org.bedu.model.User;
import org.bedu.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository repository;

    @Autowired
    private UserService service;

    @Test
    @DisplayName("UserService should be injected")
    void smokeTest(){
        assertNotNull(service);
    }

    @Test
    @DisplayName("UserService should return users from repository")
    void findAll(){
        List<User> data = new LinkedList();

        User user = new User();

        user.setId(40);
        user.setFirstName("Raul");
        user.setLastName("Jimenez");

        data.add(user);

        when(repository.findAll()).thenReturn(data);

        List<UserDTO> result = service.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertEquals(user.getId(), result.get(0).getId());
        assertEquals(user.getFirstName(), result.get(0).getFirstName());
        assertEquals(user.getLastName(), result.get(0).getLastName());
    }

    @Test
    @DisplayName("UserService should save an user in repository")
    void saveTest(){
        CreateUserDTO dto = new CreateUserDTO();
        dto.setFirstName("Miguel");
        dto.setLastName("Hernandez");
        User user = new User();
        user.setId(55);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        when(repository.save(any(User.class))).thenReturn(user);
        UserDTO result = service.save(dto);

        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getFirstName(), result.getFirstName());
        assertEquals(user.getLastName(), result.getLastName());
    }

    @Test
    @DisplayName("UserService should delete an user by id in repository")
    void deleteByIdTest(){
        service.deleteById(38l);
        verify(repository,times(1)).deleteById(38l);
    }

}
