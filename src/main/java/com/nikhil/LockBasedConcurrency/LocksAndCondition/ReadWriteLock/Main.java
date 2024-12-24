package com.nikhil.LockBasedConcurrency.LocksAndCondition.ReadWriteLock;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread th1 = new Thread(() -> {
            sharedResource.producer();
        });
        SharedResource sharedResource1 = new SharedResource();
        Thread th2 = new Thread(() -> {
            sharedResource.consume();
        });
        Thread th3 = new Thread(() -> {
            sharedResource1.consume();
        });
        th1.start();
        th2.start();
        th3.start();
    }
}
