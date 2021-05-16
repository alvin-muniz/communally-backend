package com.alvinmuniz.communallybackend.service;

import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Testing to verift the repository methods are actually being called in the
 * service and returning the specified output given the proper input
 */

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void whenSuccessfulSavedUser_thenReturnUser() {
        User user = new User();
        userService.saveUser(user);
        verify(userRepository, times(1)).save(any(User.class));
    }


}
