package com.engeto.ControllerTest.controller;

import com.engeto.ControllerTest.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    private void createDefaultUsers() {
        User user = new User();
        user.setName("Stepan");
        user.setLastName("Bohm");
        user.setUserId(1L);

        User user2 = new User("Jan", "Hlavaty", 2L, "");
        users.add(user);
        users.add(user2);

    }

    @GetMapping("create")
    public void createUsers() {
        createDefaultUsers();
    }

    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        for (User u : users) {
            if (u.getUserId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        users.add(user);

        return user;
    }
}
