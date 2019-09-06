package com.oracle;

public class R implements Runnable {
    @Override
    public void run() {
        Thread t=Thread.currentThread();
        System.out.println("**Run starts**");
        for(int i=1;i<=100;i++){
            System.out.println("i=: "+i+"Name of Thread: "+t.getName());
            }
        System.out.println("run() ends..");
    }
}
