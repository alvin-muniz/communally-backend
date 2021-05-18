package com.alvinmuniz.communallybackend.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userId) {
        super("This user not found " + userId);
    }

}
