package com.nikhil.LockBasedConcurrency.LocksAndCondition.ThreadAndMonitorLock;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Going inside Main method: "+ Thread.currentThread().getName());
//        MultiThreadingLearning runnableObj = new MultiThreadingLearning();
//        Thread thread = new Thread(runnableObj);
//        thread.start();
//
//        MultiThreadingByExtend multiThreadingByExtend = new MultiThreadingByExtend();
//        multiThreadingByExtend.start();
//
//        System.out.println("Finished Main method: "+ Thread.currentThread().getName());

//        MonitorLockExample obj = new MonitorLockExample();
//        Thread t1 = new Thread(obj::task1);
//        Thread t2 = new Thread(obj::task2);
//        Thread t3 = new Thread(obj::task3);
//        t1.start();
//        t2.start();
//        t3.start();


//        MonitorLockRunnable monitorLockRunnable = new MonitorLockRunnable(obj);
//        Thread t1 = new Thread(monitorLockRunnable);
//        Thread t2 = new Thread(obj::task2);
//        Thread t3 = new Thread(obj::task3);
//        t1.start();
//        t2.start();
//        t3.start();

//        synchronized is used to add monitor lock on object by thread.

        SharedResource sharedResource = new SharedResource();
        Thread producerThread = new Thread(() -> {
            System.out.println("Producer thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                // handle exception
            }
            sharedResource.addItem();
        });
        Thread consumerThread = new Thread(() -> {
            System.out.println("Consumer thread: "+Thread.currentThread().getName());
            sharedResource.consumeItem();
        });
        producerThread.start();
        consumerThread.start();
    }
}