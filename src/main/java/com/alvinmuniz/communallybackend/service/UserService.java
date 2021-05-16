package com.alvinmuniz.communallybackend.service;

import com.alvinmuniz.communallybackend.models.Login.LoginRequest;
import com.alvinmuniz.communallybackend.models.Login.LoginResponse;
import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.repository.UserRepository;
import com.alvinmuniz.communallybackend.security.JWTUtils;
import com.alvinmuniz.communallybackend.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    /*Authentication manager for the security context*/
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;


    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public ResponseEntity<LoginResponse> loginUser(LoginRequest loginRequest) {
        authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(loginRequest.getEmailAddress(),
                loginRequest.getPassword()));
        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(loginRequest.getEmailAddress());
        final String JWT = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(JWT));

    }

    public User findByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }
}
