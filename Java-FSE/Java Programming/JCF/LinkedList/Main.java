//* Linkedlist is easier efficient for insertion and deletion in the middle of the linkedlist
//* It is not really efficient for random access
//* It increases memory overhead due to next pointer/references in case of singly and prev and next in case of doubly linked list.
//* The LinkedList in JCF has both head and tail pointer so it takes O(1) time complexity for adding an element both at the head or the tail.

import java.util.Arrays;
import java.util.LinkedList;

class Main{
    public static void main(String[] args) {
        LinkedList<Integer> ll1 = new LinkedList<>(); //* We can also build a LinkedList object while referring it to the List class but to access the specific methods of LinkedList we need to refer it to LinkedList class.


        ll1.add(1);
        ll1.add(2);
        ll1.add(3);
        ll1.add(4);
        ll1.add(6);
        ll1.add(7);
        ll1.add(8);
        ll1.add(9);
        ll1.add(10);
        ll1.add(11);

        ll1.add(5, 15); //* Inserting at a specific index

        System.out.println(ll1.get(2));

        ll1.addFirst(0);
        ll1.addLast(5);

        System.out.println(ll1.getFirst());
        System.out.println(ll1.getLast());

        ll1.remove();

        ll1.remove(3);
        ll1.removeFirst();
        ll1.removeLast();


        ll1.removeIf(x -> x%2 == 0);

        System.out.println(ll1);

        //** Creating LinkedList On the fly
        LinkedList<String> ll2 = new LinkedList<>(Arrays.asList("Cat", "Dog", "Cow", "Monkey", "Goat")); //* Passing a list (** Not an ArrayList **) to the constructor can create a linkedlist on the fly in JCF.

        System.out.println(ll2);
    }
}