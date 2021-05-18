package com.alvinmuniz.communallybackend.service;

import com.alvinmuniz.communallybackend.models.Reflection;
import com.alvinmuniz.communallybackend.models.Session;
import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.repository.ReflectionRepository;
import com.alvinmuniz.communallybackend.security.MyUserDetails;
import com.alvinmuniz.communallybackend.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Ref;

@Service
public class ReflectionService {

    private ReflectionRepository reflectionRepository;
    private SessionService sessionService;

    private JSONUtils jsonUtils;

    @Autowired
    public ReflectionService (ReflectionRepository reflectionRepository,
                              SessionService sessionService) {
        this.reflectionRepository = reflectionRepository;
        this.sessionService = sessionService;
    }

    public static void main(String[] args) {
        Reflection reflection = new Reflection();


    }

    public Reflection createReflection(Long sessionId, Reflection reflection) {
        Session foundSession =
                sessionService.getSessionByIdAndUserId(sessionId);
        reflection.setSession(foundSession);
        return reflectionRepository.save(reflection);
    }

    public User getUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUser();
    }

}
