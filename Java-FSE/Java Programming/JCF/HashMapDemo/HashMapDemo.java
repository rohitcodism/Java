// * Map does not extend collection framework.
/*
 * Key Value pair
 * Unique Keys
 * One value per key
 * Order -> Some implementation maintains order and some of them do not maintain any order, like LinkedHashMap maintain insertion order, TreeMap maintains natural order, but HashMap maintains no order.
 */

 /*
  * Unordered
  * Can have only one null key and multiple null values
  * Not thread safe, requires external synchronization if used in multi-threaded context
  * Offers constant time performance O(1) for basic operations like .get() and .put() methods, assuming hash function disperses elements properly. 
  */
  
  /*
   * Components of Hashmap
   * Key -> Unique identifier, it is used to associate with a value.
   * Value -> A value is associated with a key.
   * Bucket -> It is a type of storage where key value pairs are stored.
   * Hash Function -> Converts a key into an index (bucket location) for storage. It takes the key as an input and returns a fixed size string mainly a numerical value.
   */
  
   /*
    * Process of storing data in a hashmap
    * Hashing the key -> Generating a unique hashcode from the input key.
    * Calculating the index -> From the unique hash code we can generate the index using the formula int index = hashCode % arraySize.
    * The key value pair is stored in the specified index of the bucket (like an array).
    */

    /*
     * Collisions and Handling Collisions
     * Collisions are the situations when two different key generate same index value after hashing.
     * To handle collision every index inside a bucket contains a LinkedList to handle collisions so two or more different <Key, Value> pairs with the same index value is stored in the same index but connected using a LinkedList.
     * [01] -> <1, "Rohit"> -> <11, "Anu">
     * [02] -> <2, "ABC"> -> <12, "XYZ">
     * But after Java 8 we use Red Black Tree or Balanced BST to avoid the O(n) time complexity during linear search in a LinkedList.
     * After a specific threshold the LinkedList in a index of a bucket gets converted into a RB Tree or Self Balancing BST to reduce the time coplexity for searching from O(n) -> O(log n)
     */

import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> hs1 = new HashMap<>();
        hs1.put(1, "Amit");
        hs1.put(2, "Anu");
        hs1.put(3, "David");

        System.out.println(hs1);

        System.out.println(hs1.get(1));
        System.out.println(hs1.get(51));

        System.out.println(hs1.containsKey(6));

        System.out.println(hs1.containsValue("Rohit"));

        // * To tarverse any hashmap
        Set<Integer> st1 = hs1.keySet();

        System.out.println("Traversing the hashmap: ");
        for(Integer i : st1){
            System.out.println(hs1.get(i));
        }

        System.out.println("Traversing the hashmap using Entry Set: ");
        Set<HashMap.Entry<Integer, String>> entrySet = hs1.entrySet();

        for(HashMap.Entry<Integer, String> entry: entrySet){
            System.out.println(entry.getKey() +  ": " + entry.getValue());
            entry.setValue(entry.getValue().toUpperCase());
        }

        System.out.println(hs1);
    }
}