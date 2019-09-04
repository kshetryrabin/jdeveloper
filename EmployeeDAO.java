package com.oracle;

import com.oracle.net.Sdp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDAO implements EmployeeOperations{
   private static List<Employee> employeeList=new ArrayList<Employee>();
   
   public int store(Employee emp){
       int size1=0;
       employeeList.add(emp);
       try(FileOutputStream fos=new FileOutputStream("C:\\demo\\emplist.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
           ){
       oos.writeObject(employeeList);
       } catch (FileNotFoundException e) {
           System.err.println(e);
           
        } catch (IOException e) {
           System.err.println(e);
        }
       //try(FileInputStream fis=new FileInputStream("C:\\demo\\emplist.txt");
           // ObjectInputStream ois= new ObjectInputStream(fis);
         //  ){
          // Employee employeeList=(Employee)ois.readObject();
      
      // } catch (FileNotFoundException e) {
         //  System.err.println(e);
       // } catch (IOException e) {
        //   System.err.println(e);
       // } catch (ClassNotFoundException e) {
          // System.err.println(e);
      //  }
            size1=employeeList.size();
        return size1;}

    @Override
    @SuppressWarnings("cast")
    public List<Employee> getAll() {
        try(            FileInputStream fis=new FileInputStream("C:\\demo\\emplist.txt");
                        ObjectInputStream ois= new ObjectInputStream(fis);
                        ){
            
               employeeList = (List<Employee>) ois.readObject();
            //employeeList.add(emp);
                
    } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        return (List<Employee>) employeeList;
    }

        @Override
    public Employee getByid(int id) throws EmployeeNotFoundException{
        Employee temp=null;
        try(FileInputStream fis=new FileInputStream("C:\\demo\\emplist.txt");
                        ObjectInputStream ois= new ObjectInputStream(fis);
            ){
            employeeList = (List<Employee>) ois.readObject();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        for (Employee emp1 : employeeList) {
              if(emp1.getId()==id){
                  temp=emp1;
                  }
            
       }
         // try {
            if(temp==null)
            throw new EmployeeNotFoundException();
       //} catch (EmployeeNotFoundException e) {
            // TODO: Add catch code
       // System.err.println(e);
       // }
          return temp;
        
    }

    @Override
    public Employee updateSalary(int id, double salary)throws EmployeeNotFoundException {
        try(FileInputStream fis=new FileInputStream("C:\\demo\\emplist.txt");
                        ObjectInputStream ois= new ObjectInputStream(fis);
            ){
            employeeList = (List<Employee>) ois.readObject();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        for (Employee employee : employeeList) {
         if(id==employee.getId()){
             employee.setSalary(salary);
             return employee;
             }
         //List emplist=employee.getId()+employee.getName()+employee.getSalary();
       }
                    return null;
    }
}
