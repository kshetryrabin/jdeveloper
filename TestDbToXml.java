package com.oracle;

import java.io.File;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.ws.soap.Addressing;

public class TestDbToXml {
    public static void main(String[] args) {
        User u=null;
        Connection con=DBUtility.establishConnection();
        try {
            System.out.println("Enter userid:");
            Scanner scan=new Scanner(System.in);
            int userid=scan.nextInt();
            
            String query="select * from user_table where userid=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1, userid);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                u=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                }
            
            JAXBContext jaxb = JAXBContext.newInstance(User.class);
            Marshaller marshaller=jaxb.createMarshaller();
            marshaller.marshal(u, new File("C:\\Users\\Nexwave\\Desktop\\xml\\user1.xml"));
            rs.close();
            pstmt.close();
            con.close();
            
        } catch (JAXBException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
