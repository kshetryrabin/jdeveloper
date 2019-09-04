package com.oracle;

public class GmailUser extends User {
    
    private String firstName;
    private String lastName;
    private long phoneNumber;

    public GmailUser(String firstName, String lastName, long phoneNumber, String emailId, String password) {
        super(emailId,password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
    public static void main(String[] args){
        GmailUser g1=new GmailUser("sachin", "Tendulkar", 423542, "sachin@gmail.com", "gshjg");
        GmailUser g2=new GmailUser("rabin", "chhetri", 6674, "rabin@gmail.com", "gfhsg");
        GmailUser[] users={g1,g2};
        for(GmailUser user : users)
{
            System.out.println("FirstName: "+user.getFirstName());
            System.out.println("LastName: "+user.getLastName());
            System.out.println("Email: "+user.getEmailId());
            System.out.println("PhoneNumber: "+user.getPhoneNumber());
            System.out.println("Password: "+user.getPassword());
} 


    
}
}
