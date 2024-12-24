package com.nikhil.LockBasedConcurrency.LocksAndCondition.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    private boolean isAvailable = false;
    private static final StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (Exception e) {
            // handle exception here
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write lock released by: " + Thread.currentThread().getName());
        }
    }

    public void consume() {
        long stamp = lock.readLock();
        try {
            System.out.println("Read lock acquired by: " + Thread.currentThread().getName());
        } catch (Exception e) {
            // handle exception here
        } finally {
            lock.unlockRead(stamp);
            System.out.println("Read lock released by: " + Thread.currentThread().getName());
        }
    }
}
