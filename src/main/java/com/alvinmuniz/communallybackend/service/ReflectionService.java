package com.alvinmuniz.communallybackend.service;

import com.alvinmuniz.communallybackend.models.Content;
import com.alvinmuniz.communallybackend.models.Reflection;
import com.alvinmuniz.communallybackend.models.Session;
import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.repository.ContentRepository;
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
    private ContentRepository contentRepository;
    private SessionService sessionService;

    private JSONUtils jsonUtils;

    @Autowired
    public ReflectionService (ReflectionRepository reflectionRepository,
                              SessionService sessionService,
                              ContentRepository contentRepository) {
        this.reflectionRepository = reflectionRepository;
        this.sessionService = sessionService;
        this.contentRepository = contentRepository;
    }

    public static void main(String[] args) {
        Reflection reflection = new Reflection();
    }

    public Reflection getReflectionByIdAndSessionId(Long reflectionId,
                                                    Long sessionId) {
        return reflectionRepository.findByIdAndSessionId(reflectionId,
                sessionId);
    }

    public Reflection createReflection(Long sessionId, Reflection reflection) {
        Session foundSession =
                sessionService.getSessionByIdAndUserId(sessionId);
        reflection.setSession(foundSession);
        return reflectionRepository.save(reflection);
    }

    public Content createReflectionContent(Long sessionId, Long reflectionId,
                                         Content content) {
        Reflection foundReflection =
                this.getReflectionByIdAndSessionId(reflectionId, sessionId);

        content.setReflection(foundReflection);

        return contentRepository.save(content);
    };


    public User getUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUser();
    }

}
