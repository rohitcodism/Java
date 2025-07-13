package com.example.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// * ReadWriteLock is also a ReenterantLock but with specific lock operations regarding Read and Write
// * It allows multiple threads to read simultaneously as long as no thread is writing but gives exclusive access (only 1 thread) for writing
// * It basically prevents unnecessary locking

public class RWLock {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writLock = rwLock.writeLock();

    private int count = 0;

    public int read(){
        readLock.lock();
        try{
            return this.count;
        } finally {
            readLock.unlock();
        }
    }

    public void write(){
        writLock.lock();
        try{
            count++;
        }finally{
            writLock.unlock();
        }
    }

    public static void main(String[] args) {
        RWLock rw1 = new RWLock();

        Runnable read = new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;i++){
                    int val = rw1.read();
                    System.out.println(Thread.currentThread().getName() + " read the value " + (val));
                }
            }
        };

        Runnable write = new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;i++){
                    rw1.write();
                    System.out.println(Thread.currentThread().getName() + " wrote the value " + (rw1.count));
                }
            }
        };

        Thread t1 = new Thread(write, "Writer 1");
        Thread t2 = new Thread(read, "Reader 1");
        Thread t3 = new Thread(read, "Reader 2");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current counter value: "+rw1.read());
    }
}
