package io.aqsha.api.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException (String exception) {
        super(exception);
    }

}
