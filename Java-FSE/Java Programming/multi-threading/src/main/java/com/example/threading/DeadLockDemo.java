package com.example.threading;

class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(
                Thread.currentThread().getName() + " has the pen, " + this + " but trying to get the paper " + paper);
                paper.finishWriting();

    }

    public synchronized void finishWriting() {
        System.out.println("Writing finished");
    }
}

class Paper {
    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(
                Thread.currentThread().getName() + " has the paper, " + this + " but trying to get the pen " + pen);
                pen.finishWriting();

    }

    public synchronized void finishWriting() {
        System.out.println("Writing finished");
    }
}

class Student1 implements Runnable{
    private Pen pen;
    private Paper paper;

    public Student1(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);
    }
}

class Student2 implements Runnable{
    private Pen pen;
    private Paper paper;

    public Student2(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized(pen){
            paper.writeWithPaperAndPen(pen);
        }
    }
}



public class DeadLockDemo {
    public static void main(String[] args) {
        Paper paper = new Paper();
        Pen pen = new Pen();
        Thread t1 = new Thread(new Student1(pen, paper), "Student 1");
        Thread t2 = new Thread(new Student2(pen, paper), "Student 2");

        t1.start();
        t2.start();
    }
}
