package com.oracle;

public class TestSynchronization {
    public static void main(String[] args) {
        TicketBooking tb= new TicketBooking();
        Thread tx=new Thread(tb,"tx");
        Thread ty=new Thread(tb,"ty");
        Thread tz=new Thread(tb,"tz");
        tx.start();
        ty.start();
        tz.start();
   }
}
