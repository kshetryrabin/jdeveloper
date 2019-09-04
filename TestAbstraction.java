package com.practise;


    
    
   abstract class Car implements Vehicle{
       public void wheels(){
           System.out.println("4 wheeler");
           }
        
        
        }
   
   abstract class Bike implements Vehicle{
       public void wheels(){
           System.out.println("2 wheeler");
           }
       
       }
   class HondaCity extends Car {

        @Override
        public void mileage() {
            System.out.println("20 kml");
        }
    }
   class HondaAmaze extends Car{
        @Override
        public void mileage() {
            System.out.println("18kml");
        }
    }
   class Unicorn extends Bike{
        @Override
        public void mileage() {
            System.out.println("40kml");
        }
    }
   public class TestAbstraction {
    public static void main(String[] args) {
        HondaCity hc= new HondaCity();
        userInterface(hc);
        Unicorn uc=new Unicorn();
        userInterface(uc);
    }
    public static void userInterface(Vehicle v){
        v.mileage();
        v.wheels();
        System.out.println("------------");
        }
}
