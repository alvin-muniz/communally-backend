package com.alvinmuniz.communallybackend.service;

import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService() { }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User findByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }
}
