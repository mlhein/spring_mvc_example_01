package com.example.spring_mvc_example_01.Error;

public class UserAlreadyExistException extends RuntimeException {
    // https://github.com/Baeldung/spring-security-registration/blob/master/src/main/java/com/baeldung/web/error/UserAlreadyExistException.java

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }

    public UserAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}
