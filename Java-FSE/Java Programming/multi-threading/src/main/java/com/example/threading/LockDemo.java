package com.example.threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * There are mainly two types of locks in Java
 * 1. Intrinsic Lock -> Also known as monitor lock, it is automatically associated with every object in Java. Synchronized methods and blocks use intrinsic locks to ensure that only one thread can execute the code at a time.
 * 2. Explicit Lock -> Explicit locks are provided by classes in the java.util.concurrent.locks package, such as ReentrantLock. They offer more flexibility than intrinsic locks, allowing features like tryLock(), timed lock acquisition, and interruptible lock waits. Explicit locks must be manually acquired and released in code, giving developers finer control over synchronization.
 */

/*
 * Lock
 * Lock is an interface
 * It has different types of methods like:
 * 1. lock() -> It works like synchronized keyword wait untill you get the lock, so we should use it in explicit lock.
 * 2. tryLock()
 * 3. unlock()
 */

public class LockDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable track = new Runnable() {
            @Override
            public void run() {
                account.withdraw(70);
            }
        };

        Thread t1 = new Thread(track, "Thread 1");
        Thread t2 = new Thread(track, "Thread 2");

        t1.start();
        t1.interrupt();
        t2.start();
    }
}

class BankAccount {
    private int balance = 200;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is attempting to withdraw");
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (amount < this.balance) {
                    System.out.println(Thread.currentThread().getName() + " is processing the withdrawl");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                        Thread.currentThread().interrupt(); // * Good Practice, better for clean up
                    } finally {
                        lock.unlock();
                    }
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " has successfully withdrawn " + amount
                            + " rupees and the remaining balance is " + balance);
                } else {
                    System.out.println("Insufficient Balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock will try again later");
            }
        } catch (Exception e) {
            System.out.println(e);
            Thread.currentThread().interrupt(); // * Good Practice
        }

        System.out.println(Thread.currentThread().isInterrupted());
    }
}
