package com.nikhil.LockBasedConcurrency.LocksAndCondition.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResourceOptimistic {
    private int a = 10;
    private static final StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.writeLock();
        System.out.println("Write lock acquired by: " + Thread.currentThread().getName());
        try {
            System.out.println("performing work");
            a = 9;
        } catch (Exception e) {
            System.out.println("Exception in producer: " + e.getMessage());
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write lock released by: " + Thread.currentThread().getName());
        }
    }

    public void consumer() {
        long stamp = lock.tryOptimisticRead(); // optimistic read stamp
        try {
            System.out.println("Optimistic read lock acquired by: " + Thread.currentThread().getName());
            // Only read operations are allowed during an optimistic read
            int readA = a;
            Thread.sleep(8000);

            if (lock.validate(stamp)) {
                System.out.println("Read was successful, value of a: " + readA);
            } else {
                System.out.println("Data was modified. Acquiring a read lock to ensure consistency.");
                // Fallback to a full read lock
                stamp = lock.readLock();
                try {
                    readA = a;
                    System.out.println("Read after acquiring read lock, value of a: " + readA);
                } finally {
                    lock.unlockRead(stamp);
                    System.out.println("Read lock released by: " + Thread.currentThread().getName());
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in consumer: " + e.getMessage());
        }
    }
}
