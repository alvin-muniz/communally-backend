package com.alvinmuniz.communallybackend.models.Login;

public class LoginRequest {

    private String emailAddress;
    private String password;

    public LoginRequest(){}

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
