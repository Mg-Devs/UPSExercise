package com.ups.exersice.UpsExercise.User;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoServiceUnitTest {

    @Test
    void findAll() {
        UserDaoService service = new UserDaoService();

        List<User> test = Arrays.asList(
                new User(1,"Monica", new Date()),
                new User(2,"Ross", new Date()),
                new User(3,"Chandler", new Date())
        );

        List<User> result = service.findAll();

        for(int i = 0; i < test.size(); i++){
            assertEquals(test.get(i).toString(),result.get(i).toString());
        }
    }

    @Test
    void save() {
        UserDaoService service = new UserDaoService();

        Date now = new Date();

        User test = new User(4,"Mario",now);
        User result = service.save(new User(null,"Mario",now));

        assertEquals(test.toString(),result.toString());
    }
}