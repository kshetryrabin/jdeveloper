package com.oracle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestEmployeeMaintainance {
    public static void main(String[] args) {
        //List<Employee> list=new ArrayList<Employee>();
        EmployeeOperations operations=new EmployeeDAO();
        Scanner scan=new Scanner(System.in);
        int option=0;
        do{
            System.out.println("Enter following options");
            System.out.println("1:store 2:display all 3:display by id 4:Update Employee salary by id 5: exit");
            option=scan.nextInt();
            switch(option){
            case 1:// ask for id,name and salary and store inside list
                System.out.println("enter id, name and salary");
               Employee emp=new Employee(scan.nextInt(), scan.next(), scan.nextInt());
                //list.add(emp);
                int count=operations.store(emp);
                System.out.println("Employee count:"+count);
                break;
            case 2:// use for loop and display all employees from list
               for (Employee emp1 : operations.getAll()) {
                    System.out.println("id:"+emp1.getId()+"Name:"+emp1.getName()+"salary:"+emp1.getSalary());
                    
    
               }
             // System.out.println( operations.getAll());
                break;
            case 3:
                System.out.println("enter id:");
                int i=scan.nextInt();
               Employee emp2=null;
                try {
                    emp2 = operations.getByid(i);
                    System.out.println("id:"+emp2.getId()+"Name:"+emp2.getName()+"salary:"+emp2.getSalary());
                } catch (EmployeeNotFoundException e) {
                    System.err.println(e);
                }
                
                      //  break;
                     
              // System.out.println(operations.getByid(i)); 
                    
              // }
                break;
            case 4:
                System.out.println("enter id:");
                int i1=scan.nextInt();
                System.out.println("enter salary:");
                double s1=scan.nextDouble();
                Employee emp3=null;
                try {
                    emp3 = operations.updateSalary(i1, s1);
                    System.out.println("id:"+emp3.getId()+"Name:"+emp3.getName()+"salary:"+emp3.getSalary());
                    System.out.println("salary updated successfully!!!");
                } catch (EmployeeNotFoundException e) {
                    System.err.println(e);
                }
                // System.out.println(operations.updateSalary(i1, s1));
                
           
            
                //for (Employee emp3 : list) {
                   // if(i1==emp3.getId()){
                     //  emp3.setSalary( emp3.getSalary()+s1);
                     //  break;
                     //  }
                  
               break;
                
             //  }
                //break;
           }
           
            }while(option!=5);
   }
}

