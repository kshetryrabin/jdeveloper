package com.oracle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialization {
    public static void main(String[] args) {
        Employee emp=new Employee(100,"rabin",12345);
        try(FileOutputStream fos=new FileOutputStream("C:\\demo\\emp.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            
           
            ){
            oos.writeObject(emp);
             
            System.out.println("Object Serialized......");
          
            } catch (IOException e) {
            System.err.println(e);
        } 
    }
}
