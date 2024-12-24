package com.nikhil.LockBasedConcurrency.LocksAndCondition.ThreadJoinAndDeamon;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting program in thread: " + Thread.currentThread().getName());
        SharedResource sharedResource = new SharedResource();
        Thread th1 = new Thread(sharedResource::produce);
        th1.setDaemon(true);
        th1.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            // hanle exception here
        }
        System.out.println("Exiting from thread: " + Thread.currentThread().getName());
    }
}
