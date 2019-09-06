package com.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
   // private static List<Employee> list=new ArrayList<Employee>();
    public Employee updateSalary(int id, double salary){
            Connection con=DBUtility.establishConnection();
            Employee emp=null;
            try{
                String query="Update emp set salary=? where id=?";
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setDouble(1, salary);
                pstmt.setInt(2, id);
               int c= pstmt.executeUpdate();
                if(c>0)
                emp=getById(id);
                
               
                
            }catch(Exception e){
                System.out.println(e);
                }
        return emp;
        }
    public int store(Employee emp){
        int status=0;
            Connection con=DBUtility.establishConnection();
            try{
                con.setAutoCommit(false);//enable transaction
                String seqQuery="values(next value for emp_seq)";
                String query1="insert into emp values(?,?,?)";
                String query2="insert into address values(?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(seqQuery);
                int seqNum=0;
                ResultSet rs=pstmt.executeQuery();
                while(rs.next()){
                    seqNum=rs.getInt(1);
                    }
                pstmt=con.prepareStatement(query1);
                
                pstmt.setInt(1, seqNum);
                pstmt.setString(2, emp.getName());
                pstmt.setDouble(3, emp.getSalary());
                 status=pstmt.executeUpdate();
                pstmt=con.prepareStatement(query2);
                pstmt.setInt(1, seqNum);
                pstmt.setString(2, emp.getAddress().getCity());
                pstmt.setString(3, emp.getAddress().getState());
                pstmt.setInt(4, emp.getAddress().getPin());
                status=pstmt.executeUpdate()+status;
                con.commit();
                rs.close();
                pstmt.close();
                con.close();
                
                
                
            }catch(Exception e){
                System.out.println(e);
                try{
                con.rollback();
                }catch(SQLException f){
                    System.out.println(f);}
                }
        
        return status;
        }
    
    public List<Employee> findAll(){
       List<Employee> list=new ArrayList<Employee>();
            Connection con=DBUtility.establishConnection();
            try{
                String query="select * from emp left join address on id=emp_id";
                    PreparedStatement pstmt=con.prepareStatement(query);
                ResultSet rs=pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                                new Address(rs.getInt(4), rs.getString(5), rs.getString(6),
                                 rs.getInt(7))));
                    
                    }
                rs.close();
                pstmt.close();
                con.close();
                
            
            }catch(Exception e){
                System.out.println(e);
                }
       
        return list;
        }
    
    public Employee getById(int id){
        Employee emp=null;
        Connection con=DBUtility.establishConnection();
        try{
            String query="select * from emp join address on id = emp_id where id=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();//7 columns will be there in the resultset
            while(rs.next()){
                emp=new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),
                                 new Address(rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
                }
            rs.close();
            pstmt.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
            }
        
        return emp;
        }
}
