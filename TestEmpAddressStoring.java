package com.oracle;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.Scanner;

public class TestEmpAddressStoring {
    public static void main(String[] args) {
        Connection con=DBUtility.establishConnection();
        try{
            String sequenceQuery="values(next value for emp_seq)";
            String insertEmpQuery="insert into emp values(?,?,?)";
            String insertAddQuery="insert into ADDRESS values(?,?,?,?)";
            Scanner scan=new Scanner(System.in);
            System.out.println("Enter name:");
            String name=scan.next();
            System.out.println("Enter Salary:");
            Double salary=scan.nextDouble();
            System.out.println("Enter city:");
            String city=scan.next();
            System.out.println("Enter state:");
            String state=scan.next();
            System.out.println("Enter pin:");
            int pin=scan.nextInt();
            //create statement for sequence
            PreparedStatement pstmt=con.prepareStatement(sequenceQuery);
            int seqNum=0;
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                seqNum=rs.getInt(1);
                }
            //create statement for employee
            pstmt=con.prepareStatement(insertEmpQuery);
            
            pstmt.setInt(1, seqNum);
            pstmt.setString(2, name);
            pstmt.setDouble(3,15000.0);
            int c=pstmt.executeUpdate();
            System.out.println("Rows Affected in emp:"+c);
            //create statement for ADDRESS and set seq,city,state,pin
            pstmt=con.prepareStatement(insertAddQuery);
            pstmt.setInt(1, seqNum);
            pstmt.setString(2,city);
            pstmt.setString(3, state);
            pstmt.setInt(4, pin);
            c=pstmt.executeUpdate()+c;
            System.out.println("Total Rows affected:"+c);
            rs.close();
            pstmt.close();
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
            }
   }
}
