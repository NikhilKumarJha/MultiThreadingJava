package com.nikhil.LockFreeConcurrency;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<200;i++){
                    sharedResource.increment();
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<200;i++){
                    sharedResource.increment();
                }
            }
        });

        th1.start();
        th2.start();

        System.out.println(sharedResource.get());
    }
}
