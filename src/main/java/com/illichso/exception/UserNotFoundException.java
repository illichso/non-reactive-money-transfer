package com.illichso.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int userId) {
        super(createMessage(userId));
    }

    private static String createMessage(int userId) {
        return "User with id " + userId + " is not found";
    }
}
