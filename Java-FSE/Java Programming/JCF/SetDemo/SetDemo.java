// * Set is almost as like as Map or HashMaps

/*
 * Sets also has three main types HashSet, TreeSet -> Follows Sorted Order, LinkedHashSet -> Follows the insertion order
 * The methods in this type of sets are also kind of same.
 */

 /*
  * In CopyOnWriteArraySet it does ensures that no ConcurrentModification Error it works just like the CopyOnWriteArrayList.
  * But in case of ConcurrentSkipList it is not guranteed that the ConcurrentModification will occur or not. As it uses a probabilistic data structures called **Skip List**.
  * It depends on the use case which to use between these two so If the priority is high read less write then we can use CopyOnWriteArraySet other if read and write both are important then use ConcurrentSkipListSet.
  * ConcurrentSkipList is called Weakly Consistent.
  */

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

class SetDemo {

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Set<Integer> st1 = new HashSet<>();

        st1.add(1);
        st1.add(6);
        st1.add(3);
        st1.add(1);

        System.out.println(st1.contains(3));
        System.out.println(st1.removeIf((x) -> isPrime(x)));

        System.out.println(st1);

        // * These sets take it Hashset, LinkedHashSet, TreeSet are not thread safe to make it thread safe or synchronized we can use the following
        Collections.synchronizedSet(st1); // * Now it has become a synchronized set. A synchronized collection aloways follows blocking operation. But as we know it effects performance. So it is not recommended to use .synchronizedSet().

        // * So it is recommended to use ConcurrentSkipListSet
        ConcurrentSkipListSet<Integer> st2 = new ConcurrentSkipListSet<>(); // * Built for high concurrency, built in thread safety, but follows non-blocking operation. So that it provides a better performance.

        Set<Integer> st3 = Set.of(1,2,3, 4, 5,6,7,8,9,10,11); // * But an Immutable set can hold more than 10 elements.

        /*Map<Integer, String> mpp1 = Map.of(
            1, "One",
            2, "Two",
            3, "Three",
            4, "Four",
            5, "Five",
            6, "Six",
            7, "Seven",
            8, "Eight",
            9, "Nine",
            10, "Ten",
            11, "Eleven"
        );*/ // * An Immutable Map can only contain 10 <K, V> pairs.

        
    }
}