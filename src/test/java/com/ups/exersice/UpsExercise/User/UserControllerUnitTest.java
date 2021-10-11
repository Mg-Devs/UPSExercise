package com.ups.exersice.UpsExercise.User;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserControllerUnitTest {

    @Test
    void getAllUsers() {
        UserController controller = new UserController(new UserDaoService());

        List<User> test = Arrays.asList(
            new User(1,"Monica", new Date()),
            new User(2,"Ross", new Date()),
            new User(3,"Chandler", new Date())
        );

        List<User> result = controller.getAllUsers();

        for(int i = 0; i < test.size(); i++){
            assertEquals(test.get(i).toString(),result.get(i).toString());
        }
    }

    @Test
    void createUser() {
        UserController controller = new UserController(new UserDaoService());

        Date now = new Date();

        User test = new User(4,"Mario",now);
        User result = controller.createUser(new User(null,"Mario",now));

        assertEquals(test.toString(),result.toString());
    }
}