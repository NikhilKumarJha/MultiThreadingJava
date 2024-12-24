package com.nikhil.LockBasedConcurrency.LocksAndCondition.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
    private boolean isAvailable = false;
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void producer() {
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (Exception e) {
            // handle exception here
        } finally {
            lock.writeLock().unlock();
            System.out.println("Write lock released by: " + Thread.currentThread().getName());
        }
    }

    public void consume() {
        try {
            lock.readLock().lock();
            System.out.println("Read lock acquired by: " + Thread.currentThread().getName());
        } catch (Exception e) {
            // handle exception here
        } finally {
            lock.readLock().unlock();
            System.out.println("Read lock released by: " + Thread.currentThread().getName());
        }
    }
}