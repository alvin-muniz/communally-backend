package com.alvinmuniz.communallybackend.exception;

public class ReflectionNotFoundException extends RuntimeException {
    public ReflectionNotFoundException(String reflectionId) {
        super("Reflection not found" + reflectionId);
    }
}
