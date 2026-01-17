package com.rest.webservices.restful_web_services.user;

import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.List;

@RestController
public class UserResource {

    //Get /USERS
    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    public List<User> retrieveAllUsers(){

        return service.findAll();
    }
}
