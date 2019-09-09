package com.oracle;

import java.io.File;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class TestUser {
    public static void main(String[] args) {
        //User use=new User();
       Connection con=DBUtility.establishConnection();
       
       try{
           JAXBContext jaxb=JAXBContext.newInstance(User.class);
           Unmarshaller unmarshaller=jaxb.createUnmarshaller();
           User u=(User)unmarshaller
               .unmarshal(new File("C:\\Users\\Nexwave\\Desktop\\xml\\user.xml"));

           //con.setAutoCommit(false);//enable transaction
           
           
           String query="insert into user_table values(?,?,?,?)";
           PreparedStatement pstmt=con.prepareStatement(query);
           pstmt.setInt(1, u.getUserid());
           pstmt.setString(2, u.getFirstname());
           pstmt.setString(3, u.getLastname());
           pstmt.setString(4, u.getPassword());
            pstmt.executeUpdate();
           con.commit();
           pstmt.close();
           con.close();
           }catch(Exception e){
               System.out.println(e);
       }
       
   }
}
