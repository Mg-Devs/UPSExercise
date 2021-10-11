package com.ups.exersice.UpsExercise.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    private static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDaoService service;

    UserController(UserDaoService service){
        this.service = service;
    }


    //getAllUsers
    //Metodo GET para obtener todos los usuarios
    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return service.findAll();
    }

    //Metodo POST para agregar un usuario
    @PostMapping(path = "/users")
    public User createUser(@Valid @RequestBody User user){
        User newUser = service.save(user);
        LOG.info("User Created: "+ user);

        return newUser;
    }

}
