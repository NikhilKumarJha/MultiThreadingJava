package com.nikhil.LockBasedConcurrency.LocksAndCondition.Condition;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sharedResource.consumer();
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sharedResource.producer();
            }
        });
        th1.start();
        th2.start();
    }
}
