package com.alvinmuniz.communallybackend.exception;

public class ContentNotFoundException extends RuntimeException{

    public ContentNotFoundException(String contentId) {
        super("This content not found" + contentId);
        }
}
