package com.oracle;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.derby.jdbc.ClientDriver;

public class TestStoring {
    public static void main(String[] args) {
        try{
            Connection con=DBUtility.establishConnection();
           // String query="insert into emp values(1,'Charles',50000.0)";
           // int c= stmt.executeUpdate(query);
          //  System.out.println("Row affected: "+c);
          // stmt.close();
            String query= "insert into emp values(?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1, 6);
            pstmt.setString(2, "sabin");
            pstmt.setDouble(3, 10200.0);
            int c=pstmt.executeUpdate();
            System.out.println("Rows Affected: "+c);
//            String query="select * from emp";
//            PreparedStatement pstmt=con.prepareStatement(query);
//            ResultSet rs=pstmt.executeQuery();
//            while(rs.next()){
//                int i=rs.getInt(1);
//                String name=rs.getString(2);
//                Double salary=rs.getDouble(3);
//                System.out.println("id: "+i+" Name: "+name+" Salary: "+salary);
//                
//                }
//            
            pstmt.close();
            
            con.close();
            
            
        }catch(Exception e){
            System.out.println(e);
                      }
   }
}
