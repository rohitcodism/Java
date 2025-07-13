package com.example.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// * Fair locks prevents starvation of threads
// * Synchronize does not gurantee fairness
// * Indefinately Blocking
// * No interuptability in synchronized

public class FairLock {

    private final Lock unfairLock = new ReentrantLock(true);

    public void accessResources() {
        unfairLock.lock();
        System.out.println(Thread.currentThread().getName() + " acquired the lock");
        try {
            Thread.sleep(0);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " releasing the lock");
            unfairLock.unlock();
        }
    }

    public static void main(String[] args) {

        FairLock fl1 = new FairLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                fl1.accessResources();
            }
        };

        Lock lock = new ReentrantLock(true); // Try with false and true

        Runnable task2 = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    System.out.println(name + " acquired the lock");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(name + " releasing the lock");
                    lock.unlock();
                }
            }
        };

        Thread t1 = new Thread(task2, "Thread 1");
        Thread t2 = new Thread(task2, "Thread 2");
        Thread t3 = new Thread(task2, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
