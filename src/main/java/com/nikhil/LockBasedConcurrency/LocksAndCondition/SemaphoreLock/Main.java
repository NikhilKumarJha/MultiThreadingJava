package com.nikhil.LockBasedConcurrency.LocksAndCondition.SemaphoreLock;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sharedResource.producer();
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sharedResource.producer();
            }
        });

        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                sharedResource.producer();
            }
        });

        th1.start();
        th2.start();
        th3.start();
    }
}
