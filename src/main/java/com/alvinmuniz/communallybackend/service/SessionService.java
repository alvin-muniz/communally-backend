package com.alvinmuniz.communallybackend.service;

import com.alvinmuniz.communallybackend.exception.SessionNotFoundException;
import com.alvinmuniz.communallybackend.models.Session;
import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.repository.SessionRepository;
import com.alvinmuniz.communallybackend.security.MyUserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParseException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class SessionService {



    private SessionRepository sessionRepository;

    private MyUserDetails myUserDetails;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session getSessionByIdAndUserId(Long sessionId) {
        MyUserDetails userDetails = (MyUserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return sessionRepository.findByUserIdAndId(userDetails.getUser().getId(), sessionId);
    }

    public List<Session> getAllSessionsByUserId() {
        return sessionRepository.findAllByUserId(getUser().getId());
    }

    /*
    *
    * JSON Shape
    "id": 1,
    "date": "2015-03-01",
    "duration": "PT27H46M40S"
    * */

    public Session createSession(Session session) {

        MyUserDetails userDetails = (MyUserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setUser(userDetails.getUser());
        session.setDate(LocalDate.now());
        Session createdSession = sessionRepository.save(session);

       return createdSession;
    }

    public User getUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUser();
    }
}
