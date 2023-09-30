package com.in28minutes.ranga.socialmediaapplication.users;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import  static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        User user=service.findOne(id);
        EntityModel<User> entityModel=EntityModel.of(user);
        WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser=service.saveUser(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return  ResponseEntity.created(location).build();
    }
}
