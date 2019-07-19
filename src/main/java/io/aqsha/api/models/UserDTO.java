package io.aqsha.api.models;

public class UserDTO {
    private String username;
    private String password;
    private String email;

    // this class is neccessary to get the input information from client and
    // save it into the database, without this class there is an Error 500

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String password) {
//        this.email = email;
//    }
}