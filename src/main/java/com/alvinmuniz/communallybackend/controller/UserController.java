package com.alvinmuniz.communallybackend.controller;

import com.alvinmuniz.communallybackend.models.Login.LoginRequest;
import com.alvinmuniz.communallybackend.models.Login.LoginResponse;
import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.test.web.client.TestRestTemplate;

@RestController
@RequestMapping("auth/users")
public class UserController {

    private UserService userService;

    private final String BASE_URL = "/auth/users";


    private TestRestTemplate restTemplate;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<User> userRegister(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.saveUser(user), HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> loginRegister(@RequestBody LoginRequest loginRequest) {
        return this.userService.loginUser(loginRequest);
    }

}
