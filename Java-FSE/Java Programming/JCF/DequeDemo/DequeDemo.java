/*
 * Queue offers multiple operational methods like
 * 1. .add(), .offer(),
 * 2. .remove(), .poll(),
 * 3. .peek(), .element()
 */

import java.util.LinkedList;
import java.util.Queue;

class DequeDemo{
    public static void main(String[] args) {
        // * LinkedList can also work as a Queue
        LinkedList<Integer> ql1 = new LinkedList<>();

        ql1.addLast(1);
        ql1.addLast(2);
        ql1.addLast(3);
        ql1.addLast(4);
        ql1.addLast(5);

        ql1.removeFirst();

        System.out.println(ql1);

        Queue<Integer> q1 = new LinkedList<>();
        q1.add(10);
        q1.add(20);
        q1.add(30);
        q1.add(40);
        q1.add(50);
        
        System.out.println(q1.remove());

        System.out.println(q1.peek());
        System.out.println(q1);

        /*
         * Queue Methods Comparison:
         * 
         * 1. add(E e): Inserts the specified element into the queue. Throws IllegalStateException if the queue is full.
         * 2. offer(E e): Inserts the specified element into the queue. Returns false if the queue is full.
         * 3. remove(): Retrieves and removes the head of the queue. Throws NoSuchElementException if the queue is empty.
         * 4. poll(): Retrieves and removes the head of the queue, or returns null if the queue is empty.
         * 5. element(): Retrieves, but does not remove, the head of the queue. Throws NoSuchElementException if the queue is empty.
         * 6. peek(): Retrieves, but does not remove, the head of the queue, or returns null if the queue is empty.
         */

        // Demonstrating the methods:
        Queue<Integer> q2 = new LinkedList<>();

        // add() vs offer()
        q2.add(100);    // Throws exception if fails
        q2.offer(200);  // Returns false if fails

        // remove() vs poll()
        System.out.println(q2.remove()); // Removes and returns head, exception if empty
        System.out.println(q2.poll());   // Removes and returns head, null if empty

        // element() vs peek()
        q2.offer(300);
        System.out.println(q2.element()); // Returns head, exception if empty
        System.out.println(q2.peek());    // Returns head, null if empty
    }
}