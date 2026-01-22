package com.rest.webservices.restful_web_services.user;

import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
public class UserResource {

    //GET /USERS
    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {

        return service.findAll();

    }

    //GET /USER
    @GetMapping("/users/{id}")
    public User retrieveUsers(@PathVariable int id) {

        return service.findOne(id);

    }

    //POST /users
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        service.save(user);
    }
}
