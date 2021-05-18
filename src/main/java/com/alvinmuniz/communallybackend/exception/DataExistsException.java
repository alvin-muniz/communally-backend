package com.alvinmuniz.communallybackend.exception;

public class DataExistsException extends RuntimeException {
    public DataExistsException(String message) {
        super ("This information exists: " + message);
    }
}
