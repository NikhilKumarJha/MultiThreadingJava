package com.nikhil.LockBasedConcurrency.LocksAndCondition.StampedLock;

public class Main {
    public static void main(String[] args){
        SharedResourceOptimistic sharedResource = new SharedResourceOptimistic();
        Thread th1 = new Thread(() -> {
            sharedResource.consumer();
        });
        SharedResourceOptimistic sharedResource1 = new SharedResourceOptimistic();
        Thread th2 = new Thread(() -> {
            sharedResource.producer();
        });

        th1.start();
        th2.start();
    }
}
