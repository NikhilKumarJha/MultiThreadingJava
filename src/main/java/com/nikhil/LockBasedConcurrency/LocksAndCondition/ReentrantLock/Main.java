package com.nikhil.LockBasedConcurrency.LocksAndCondition.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread th1 = new Thread(() -> {
            sharedResource.producer();
        });
        SharedResource sharedResource1 = new SharedResource();
        Thread th2 = new Thread(() -> {
            sharedResource1.producer();
        });
        th1.start();
        th2.start();
    }
}
