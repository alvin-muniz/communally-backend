package com.alvinmuniz.communallybackend.service;

import com.alvinmuniz.communallybackend.exception.DataExistsException;
import com.alvinmuniz.communallybackend.exception.ReflectionNotFoundException;
import com.alvinmuniz.communallybackend.exception.SessionNotFoundException;
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
import java.util.List;
import java.util.Optional;

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

    public Reflection getReflectionByIdAndSessionId(Long reflectionId,
                                                    Long sessionId) {
        return reflectionRepository.findByIdAndSessionId(reflectionId,
                sessionId);
    }

    public List<Reflection> getAllReflection() {
        return reflectionRepository.findAll();
    }

    public List<Content> getReflectionAllContent(Long sessionId,
                                                 Long reflectionId) {
        Optional<Reflection> foundReflection =
                Optional.ofNullable(this.getReflectionByIdAndSessionId(reflectionId, sessionId));
        if(!foundReflection.isPresent()){
            throw new ReflectionNotFoundException(" No reflection found");
        }
            return this.contentRepository.findAllByReflectionId(reflectionId);
    }

    public Reflection createReflection(Long sessionId, Reflection reflection) {

        if(sessionService.getSessionByIdAndUserId(sessionId).getReflection() != null)
        {
            throw new DataExistsException("Cannot create more than 1 " +
                    "reflection");
        }
        Session foundSession =
                sessionService.getSessionByIdAndUserId(sessionId);

        reflection.setSession(foundSession);
        return reflectionRepository.save(reflection);
    }

    public Content createReflectionContent(Long sessionId, Long reflectionId,
                                         Content content) {
        Optional<Reflection> foundReflection =
                Optional.ofNullable(this.getReflectionByIdAndSessionId(reflectionId, sessionId));
      if(!foundReflection.isPresent()){
          throw new ReflectionNotFoundException("No reflection to add to");
      }
      content.setReflection(foundReflection.get());
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
