package com.alvinmuniz.communallybackend.controller;

import com.alvinmuniz.communallybackend.models.Session;
import com.alvinmuniz.communallybackend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("")
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        return new ResponseEntity<>(this.sessionService.createSession(session), HttpStatus.OK);
    }

    @GetMapping("{sessionId}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long sessionId) {
        return new ResponseEntity<>(this.sessionService.getSessionByIdAndUserId(sessionId), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Session>> getAllSessionsByUserId() {
        return new ResponseEntity<>(this.sessionService.getAllSessionsByUserId(), HttpStatus.OK);
    }


}
