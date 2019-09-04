package com.oracle;

class Person{
    void display(){
        System.out.println("person name and gender");
        }
    }
class Employee extends Person{
    void display(){
        System.out.println("Employee id, Name, Salary and gender");
        }
    void raiseSalary(){
        System.out.println("employee salary raised");
        }
    }
class Student extends Person{
    void display(){
        System.out.println("Student roll no, Name, Gender and grade");
        }
    void updateGrade(){
        System.out.println("student grade updated");
        }
    }

public class TestPolymorphism {
    public static void main(String[] args) {
    Employee emp=new Employee();
    test(emp);
    Student std=new Student();
    test(std);
    }
    public static void test(Person px){
        px.display();
        if(px instanceof Employee){
           Employee ex=(Employee)px;
           System.out.println("employee object......");
           ex.raiseSalary();
           }
        if(px instanceof Student){
            Student sx=(Student)px;
            System.out.println("Student object....");
            sx.updateGrade();
            }
            
        }
}

