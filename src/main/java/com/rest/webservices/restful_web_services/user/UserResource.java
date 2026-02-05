package com.rest.webservices.restful_web_services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
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
        User user = service.findOne(id);
        if(user== null){
            throw new UserNotFoundException("id: "+ id);
        }

        return user;

    }

    //POST /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
