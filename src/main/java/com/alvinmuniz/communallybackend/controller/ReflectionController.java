package com.alvinmuniz.communallybackend.controller;

import com.alvinmuniz.communallybackend.models.Reflection;
import com.alvinmuniz.communallybackend.models.Session;
import com.alvinmuniz.communallybackend.service.ReflectionService;
import com.alvinmuniz.communallybackend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sessions/")
public class ReflectionController {

    private ReflectionService reflectionService;

    private SessionService sessionService;

    @Autowired
    public ReflectionController(ReflectionService reflectionService,
                                SessionService sessionService) {
        this.reflectionService = reflectionService;
        this.sessionService = sessionService;
    }

    @PostMapping("{sessionId}/reflections")
    public Reflection saveReflection(@PathVariable Long sessionId,
                                     @RequestBody Reflection reflection) {
       return  this.reflectionService.createReflection(sessionId, reflection);
    }
}
