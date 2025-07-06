// * Deque -> Double Ended Queue
/*
 * A double ended queue allows insertion and removal from both sides
 */

/*
 * Insertion methods of Deque:
 * - addFirst(E e): Inserts the specified element at the front of this deque.
 * - addLast(E e): Inserts the specified element at the end of this deque.
 * - offerFirst(E e): Inserts the specified element at the front, returns true if successful.
 * - offerLast(E e): Inserts the specified element at the end, returns true if successful.
 * - push(E e): Pushes an element onto the stack represented by this deque (same as addFirst).
 */

/*
 * Removal Methods of Deque
 * - removeFirst(): Removes and returns the first element of this deque.
 * - removeLast(): Removes and returns the last element of this deque.
 * - pollFirst(): Retrieves and removes the first element, or returns null if this deque is empty.
 * - pollLast(): Retrieves and removes the last element, or returns null if this deque is empty.
 * - pop(): Pops an element from the stack represented by this deque (same as removeFirst).
*/

/*
 * An ArrayDeque is a resizable array implementation of Deque
 * It is faster than stack when used as stack and faster than queue when used as LinkedList
 * But in ArrayDeque No NULL values are allowed, otherwise it will throw null pointer exception
 * It is not threadsafe
 * It uses a circular array to store elements with a head and a tail pointer
 * This cicular array implements a Wrapping Around mechanism for efficient sotrage usage
 * When head and tail pointers are same position then size of array is doubled
 * Insertion -> head-- and Deletion -> head++ (from first)
 * Insertion -> tail++ and Deletion -> tail-- (from last)
 * That is why it is first no need to Shift the elements only shift the head and tail pointers
 */

import java.util.ArrayDeque;
import java.util.Deque;

class DequeDemoo {
    public static void main(String[] args) {
        Deque<Integer> dq1 = new ArrayDeque<>();
        dq1.addFirst(10);
        dq1.addLast(20);
        dq1.offerFirst(5);
        dq1.offerLast(25);

        System.out.println(dq1.getFirst());
        System.out.println(dq1.getLast());

        System.out.println(dq1.peek());

        //System.out.println(dq1.remove());

        System.out.println(dq1);
    }
}