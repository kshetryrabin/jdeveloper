package com.oracle;
public class TicketBooking implements Runnable{
    private int ticket=1;
    @Override
    public void run() {
        book();
    }
    public synchronized void book(){
        String name=Thread.currentThread().getName();
        if(ticket>0){
            System.out.println("hi "+name+" ticket booked successfully");
            ticket--;        
            }
        else{
            System.out.println("sorry "+name+" tickets are sold out");
            }
        
        }
}
