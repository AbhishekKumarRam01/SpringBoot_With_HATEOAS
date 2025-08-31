package com.abhi.it.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.it.entity.User;

@RestController
public class UserRestController {

    // 1️⃣ Single User with self + all-users link
    @GetMapping("/greet")
    public User getInfo() {
        User user = new User();
        user.setId(101);
        user.setName("Abhishek Kumar");
        user.setEmail("abhi@example.com");

       user.add(linkTo(methodOn(UserRestController.class).getInfo()).withSelfRel());
        user.add(linkTo(methodOn(UserRestController.class).getAllUsers()).withRel("users"));

        return user;
    }

    // 2️⃣ Get user by id
    @GetMapping("user/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        User user = new User();
        user.setId(id);
        user.setName("Abhi It");
        user.setEmail("abhishekonedev01@gmail.com");

        EntityModel<User> u1 = EntityModel.of(user);
        u1.add(linkTo(methodOn(UserRestController.class).getUser(id)).withSelfRel());
        u1.add(linkTo(methodOn(UserRestController.class).getAllUsers()).withRel("users"));
        u1.add(linkTo(methodOn(UserRestController.class).getInfo()).withRel("greet"));// add For Greet link information

        return u1;
    }

    // 3️⃣ All users (dummy hardcoded list for demo)
    @GetMapping("/users")
    public CollectionModel<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        User u1 = new User();
        u1.setId(1);
        u1.setName("Abhi");
        u1.setEmail("abhi@example.com");
        u1.add(linkTo(methodOn(UserRestController.class).getUser(1)).withSelfRel());

        User u2 = new User();
        u2.setId(2);
        u2.setName("Sourabh");
        u2.setEmail("sourabh@example.com");
        u2.add(linkTo(methodOn(UserRestController.class).getUser(2)).withSelfRel());

        users.add(u1);
        users.add(u2);

        return CollectionModel.of(users,
                linkTo(methodOn(UserRestController.class).getAllUsers()).withSelfRel());
    }
}
