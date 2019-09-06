package com.oracle;

import java.util.List;
import java.util.Scanner;

public class TestEmployeeManagement {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        EmployeeDAO dao=new EmployeeDAO();
        int option=0;
        do{
            System.out.println("1:Store 2:FindAll 3:FindById 4:UpdateSalaryById 5:Exit");
            option=scan.nextInt();
            switch(option){
            case 1:
                System.out.println("Enter name:");
                System.out.println("Enter Salary:");
                System.out.println("Enter City:");
                System.out.println("Enter State:");
                System.out.println("Enter Pin:");
               int ef1= dao.store(new Employee(0,scan.next(),scan.nextDouble(),
                                       new Address(0,scan.next(),scan.next(),scan.nextInt())));
                System.out.println("Successfully stored...");
                System.out.println("Rows affected:"+ef1);
                
                
                
                
                
                break;
            case 2:
               // List<Employee> list=dao.findAll();
                for(Employee ef : dao.findAll()){
                        System.out.println("Id: "+ef.getId()+" Name: "+ef.getName()+" Salary: "+ef.getSalary()+" City: "
                                           +ef.getAddress().getCity()+" State: "+ef.getAddress().getState()+" Pin: "
                                           +ef.getAddress().getPin());
                    }
                
                break;
            case 3:
                System.out.println("Enter id:");
                Employee ef=dao.getById(scan.nextInt());
                if(ef !=null)
                    System.out.println("Id: "+ef.getId()+" Name: "+ef.getName()+" Salary: "+ef.getSalary()+" City: "
                                       +ef.getAddress().getCity()+" State: "+ef.getAddress().getState()+" Pin: "
                                       +ef.getAddress().getPin());
                    
                else
                    System.out.println("!!!!Employee not found!!!!!");
                
                break;
            case 4:
                System.out.println("Enter id:");
                System.out.println("Enter salary:");
                Employee es=dao.updateSalary(scan.nextInt(), scan.nextDouble());
                if(es !=null){
                System.out.println("Salary Updated Successfully.....");
                System.out.println("Id: "+es.getId()+" Name: "+es.getName()+" Salary: "+es.getSalary()+" City: "
                                   +es.getAddress().getCity()+" State: "+es.getAddress().getState()+" Pin: "
                                   +es.getAddress().getPin());
                }
               else
                   System.out.println("Id not Matching....");
                break;
            }
            }while(option!=5);
   }
}
