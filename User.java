package com.oracle;

public class User {
    private String emailId;
    private String password;

    public User(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

   
    public String getEmailId() {
        return emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
