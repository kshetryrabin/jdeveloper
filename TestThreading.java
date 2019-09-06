package com.oracle;

public class TestThreading {
   public static void main(String[] args) {
       Thread t=Thread.currentThread();
       System.out.println("**main starts**Name of Thread: "+t.getName());
        R r1=new R();  //runnable instance
       //Bike r1=new Bike();
        Thread tx= new Thread(r1,"tx");
        Thread ty=new Thread(r1,"ty");
        Thread tz=new Thread(r1,"tz");
        tx.start();
        ty.start();
        tz.start();
        System.out.println("*****Main ends****Name of Thread: "+t.getName());
   }
}
