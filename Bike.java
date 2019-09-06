package com.oracle;

public class Bike implements Runnable {
    @Override
    public void run() {
        Thread t=Thread.currentThread();
        for(int i=1;i<=10;i++){
            System.out.println(t.getName()+" completes lap: "+i);
            }
    }
}
