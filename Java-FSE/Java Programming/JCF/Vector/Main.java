//* Vector was introduced in JDK 1.0 before JCF also it is synchronized making it thread safe. But it also has synchronization overhead. So it is recommended while working on single thread concerns we should use modern alternatives like ArrayList, LinkedList etc. But in case multithreading concerns we should use vector due to it's thread safety property.

/*
 * Properties of Vector
    *1. Dynamic Array
    *2. Synchronization
    *3. Legacy Class -> Part of Java's original release
    *4. Random Access
 */

// * Each and every method of vector is a synchronized method. But this synchronization also effects the performance of the program due synchronization overhead like locking, unlocking.

import java.util.LinkedList;
import java.util.Vector;

class VectorDemo {
   public static void main(String[] args) {
      Vector<Integer> v1 = new Vector<>(6, 3); // * Here the second argument in the constructor is the capacityIncrement
      v1.add(1);
      v1.add(2);
      v1.add(3);
      v1.add(4);
      v1.add(5);
      v1.add(6);

      System.out.println(v1);

      v1.add(7);

      // * In case of vector the capacity increases by 2X unlike ArrayList where It was increasing by 1.5X. But in case of vector we can also control the capacity increment by passing an argument ine the constructor during object creation
      System.out.println(v1.capacity());



      // * Unlike ArrayList, Vector has a method to check it's capacity
      Vector<Integer> v2 = new Vector<>();
      System.out.println(v2.capacity()); // * And the initial capacity of vector is 10 just like an ArrayList.

      // * We can create a Vector on the fly by passing any type of collection in the constructor as an argument or parameter.
      LinkedList<Integer> ll1 = new LinkedList<>();
      ll1.add(1);
      ll1.add(2);
      ll1.add(3);


      Vector<Integer> v3 = new Vector<>(ll1);
      System.out.println(v3);


   }
 }