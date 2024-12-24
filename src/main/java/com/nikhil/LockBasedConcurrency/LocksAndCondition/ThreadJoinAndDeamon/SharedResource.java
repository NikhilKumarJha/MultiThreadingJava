package com.nikhil.LockBasedConcurrency.LocksAndCondition.ThreadJoinAndDeamon;

public class SharedResource {
    boolean isAvailable = false;

    public synchronized void produce() {
        System.out.println("Lock acquired by: " + Thread.currentThread().getName());
        isAvailable = true;
        try {
            Thread.sleep(8000);
        } catch (Exception e) {
            // handle exception here
        }
        System.out.println("Lock release by: " + Thread.currentThread().getName());
    }
}
