package com.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSelect {
    public static void main(String[] args) {
        try{
            Connection con=DBUtility.establishConnection();
            String query="select * from emp";
            PreparedStatement pstmt=con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                int i=rs.getInt(1);
                String name=rs.getString(2);
                Double salary=rs.getDouble(3);
                System.out.println("id: "+i+" Name: "+name+" Salary: "+salary);
                
                }
            
            pstmt.close();
            
            con.close();
        }catch(Exception e)
        {
                  System.out.println(e);
               }
   }
}
