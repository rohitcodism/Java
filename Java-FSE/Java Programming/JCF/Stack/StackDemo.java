// * Stack is a Collection in JCF. It extends Vector. And as it extends vector Stack is also synchronized and thread safe.

// * In case of single threaded environment we can use LinkedList from JCF as a Stack as the LinkedList in JCF is a doubly LinkedList. And it takes O(1) time complexity for adding an element to the last or tail otherwise it was not possible. Also We can use ArrayList as a Stack in single threaded environment.


import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(5);
        s1.push(6);
        s1.push(7);
        s1.push(8);
        s1.push(9);
        s1.push(4);
        s1.push(3);

        System.out.println(s1.pop());
        System.out.println(s1.peek());
        System.out.println(s1.size());

        System.out.println(s1);


    }
}