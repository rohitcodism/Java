package com.example.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantDemo {

    private final ReentrantLock lock = new ReentrantLock(); // * It pairs each lock method with a unlock method

    public void outerMethod(){
        System.out.println(lock.getHoldCount());
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Outer method");
            System.out.println(lock.getHoldCount());
            innerMethod();
        } finally {
            lock.unlock();
            System.out.println(lock.getHoldCount());
        }
    }

    public void innerMethod(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Inner method");
            System.out.println(lock.getHoldCount());
        } finally {
            lock.unlock();
            System.out.println(lock.getHoldCount());
        }
    }

    public static void main(String[] args) {
        ReenterantDemo r1 = new ReenterantDemo();

        r1.outerMethod();
    }
    
}
