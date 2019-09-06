package com.oracle;

public class TestJoining {
    public static void main(String[] args) {
        System.out.println("**Game Starts***");
        Bike b1= new Bike();
       Thread tx= new Thread(b1,"tx");
       Thread ty=new Thread(b1,"ty");
       Thread tz=new Thread(b1,"tz");
       tx.start();
       ty.start();
       tz.start();
        try {
            tx.join();
            ty.join();
            tz.join();
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println("*****Game ends****");
   }
}
