package com.nikhil.LockBasedConcurrency.LocksAndCondition.ProducerConsumerProblem;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    sharedResource.produce(i);
                } catch (InterruptedException e) {
                    // handle exception here
                }
            }
        });

        Thread consumerThread = new Thread(()->{
            for(int i=0;i<6;i++){
                try {
                    sharedResource.consume();
                } catch (InterruptedException e) {
                    // handle exception here
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
