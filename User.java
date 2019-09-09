package com.oracle;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private int userid;
    private String firstname;
    private String lastname;
    private String password;

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public User(){
        }
    public User(int userid, String firstname, String lastname, String password) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }
}
