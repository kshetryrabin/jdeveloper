package com.oracle;

import java.io.File;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TestStoringMultipleUsers {
    public static void main(String[] args) {
     
      
        try{
        JAXBContext jaxb=JAXBContext.newInstance(UserCollection.class);
            //Unmarshalling: from xml to database
            
           // Unmarshaller unmarshaller=jaxb.createUnmarshaller();
            //get the userdetails from xml(userdetails) and store in object of UserCollection
           // UserCollection userCollection=(UserCollection)unmarshaller.unmarshal(new File("C:\\Users\\Nexwave\\Desktop\\xml\\userdetail.xml"));
           //store userCollection into userList of User class in a list
          //  List<User> userList=userCollection.getUserList();
          //  for (User u : userList) {
           //     System.out.println("Id: "+u.getUserid()+" Firstname: "+u.getFirstname()+" Lastname: "+u.getLastname()+" Password: "+u.getPassword());
               //stores user data into user_table table in derby database via store() method
              //  store(u);
          
          
          // Marshalling: Database to xml file
            
            
            List<User> userList=getAllUsers();
            UserCollection userCollection=new UserCollection();
            userCollection.setUserList(userList);
            Marshaller marshaller=jaxb.createMarshaller();
            marshaller.marshal(userCollection, new File("userDetails1.xml"));// creates xml file within the project
            System.out.println("Java List to xml......");
            
             
        } catch (JAXBException e) {
            System.out.println(e);
        }


  
   }
    public static void store(User u){
        try{
            Connection con=DBUtility.establishConnection();
            String query="insert into user_table values(?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1, u.getUserid());
            pstmt.setString(2, u.getFirstname());
            pstmt.setString(3, u.getLastname());
            pstmt.setString(4, u.getPassword());
            pstmt.executeUpdate();
              
        }catch(Exception e){
            System.out.println(e);
            }}
    public static List<User> getAllUsers(){
        List<User> userList=new ArrayList<User>();
        try{
        Connection con=DBUtility.establishConnection();
            String query1="select * from user_table";
            PreparedStatement pstmt=con.prepareStatement(query1);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                userList.add(user);
                }
            rs.close();
        }catch(Exception e){
        System.out.println(e);
        }
        return userList;
        }
}
