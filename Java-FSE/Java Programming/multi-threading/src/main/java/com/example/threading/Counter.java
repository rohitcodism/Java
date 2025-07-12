package com.example.threading;

public class Counter {
    private int count = 0;

    public synchronized void increment(){ // * -> synchronized method
        count++;  // * -> Critical section of the code
    }

    /*public void increment(){
        synchronized(this){ // * -> Synchronized block
            count++;
        }
    }*/

    public int getCount(){
        return count;
    }
}
