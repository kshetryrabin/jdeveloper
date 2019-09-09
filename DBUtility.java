package com.oracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
    public static Connection establishConnection(){
        Connection con=null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url="jdbc:derby://localhost:1527/javadb";
            String un="admin";
            String pw="admin";
             con= DriverManager.getConnection(url,un,pw);
        }catch(Exception e){
            System.out.println(e);
            }
        return con;
        }
    }

