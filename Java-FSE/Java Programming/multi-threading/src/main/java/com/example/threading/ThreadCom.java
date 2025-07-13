package com.example.threading;

// * Without proper thread cmmunication CPU resource will be waste for polling

class SharedResource {
    private int data = 0;
    private boolean hasData = false;
    
    public synchronized void produce(int val){
        while(hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.data = val;
        hasData = true;
        System.out.println("Producer produced: " + val);
        notify();
    }

    public synchronized int consume(){
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        hasData = false;
        System.out.println("Consumer consumed: " + this.data);
        notify();
        return this.data;
    }
}

class Producer implements Runnable{
    private SharedResource resource;

    Producer(SharedResource res){
        this.resource = res;
    }

    @Override
    public void run() {
        for(int i = 1;i<=10;i++){
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable{
    private SharedResource resource;

    Consumer(SharedResource res){
        this.resource = res;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10;i++){
            int val = resource.consume();
        }
    }
}

public class ThreadCom {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        
        Thread producerThread = new Thread(new Producer(resource), "Producer");
        Thread consumerThread = new Thread(new Consumer(resource), "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}