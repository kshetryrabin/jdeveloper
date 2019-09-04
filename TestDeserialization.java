package com.oracle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestDeserialization {
    public static void main(String[] args) {
        try(            FileInputStream fis=new FileInputStream("C:\\demo\\emp.txt");
                        ObjectInputStream ois= new ObjectInputStream(fis);
                        ){
            
                Employee emp=(Employee)ois.readObject();
                 System.out.println("Object Deserialized......");
            System.out.println("id: "+emp.getId()+" Name: "+emp.getName()+" Salary: "+emp.getSalary());
                
            } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}
