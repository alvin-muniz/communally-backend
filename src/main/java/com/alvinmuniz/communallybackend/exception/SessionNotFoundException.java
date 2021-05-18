package com.alvinmuniz.communallybackend.exception;

public class SessionNotFoundException extends RuntimeException {

    public SessionNotFoundException(String sessionId) {
        super("This session was not found" + sessionId);
    }
}
