package com.alvinmuniz.communallybackend.controller;

import com.alvinmuniz.communallybackend.models.Content;
import com.alvinmuniz.communallybackend.models.Reflection;
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

    @GetMapping("{sessionId}/reflections/{reflectionId}")
    public Reflection getReflectionByIdAndSessionId(
            @PathVariable Long sessionId, @PathVariable Long reflectionId
    ) {
        return this.reflectionService.getReflectionByIdAndSessionId(reflectionId, sessionId);
    }

    @PostMapping("{sessionId}/reflections")
    public Reflection saveReflection(@PathVariable Long sessionId,
                                     @RequestBody Reflection reflection) {
       return  this.reflectionService.createReflection(sessionId, reflection);
    }

    @PostMapping("{sessionId}/reflections/{reflectionId}/content")
    public Content createReflectionContent(@PathVariable Long sessionId,
                                     @PathVariable Long reflectionId,
                                     @RequestBody Content content) {
      return this.reflectionService.createReflectionContent(sessionId,
              reflectionId,content);
    }
}
