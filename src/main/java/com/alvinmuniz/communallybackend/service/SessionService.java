package com.alvinmuniz.communallybackend.service;

import com.alvinmuniz.communallybackend.models.Session;
import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.repository.SessionRepository;
import com.alvinmuniz.communallybackend.security.MyUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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


    public Session createSession(Session session) {
        MyUserDetails userDetails = (MyUserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setUser(userDetails.getUser());

       return sessionRepository.save(session);
    }

    public User getUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUser();
    }
}
