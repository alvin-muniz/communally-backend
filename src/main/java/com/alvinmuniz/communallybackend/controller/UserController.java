package com.alvinmuniz.communallybackend.controller;

import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.test.web.client.TestRestTemplate;

@RestController
@RequestMapping("auth/users")
public class UserController {

    private UserService userService;

    private final String BASE_URL = "/auth/users";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("register")
    public User userRegister(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

}
