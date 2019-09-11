package com.oracle;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
// Storing multiple users data from xml file to table in a database using loop
@XmlRootElement(name="users")
public class UserCollection {
    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlElement(name="user")
    public List<User> getUserList() {
        return userList;
    }
}
