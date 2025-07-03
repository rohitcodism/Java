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

     /*
      * When the number of elements grows and exceeds a certain load factor (default is 0.75), HashMap automatically resizes the array to hold more data. This Process is called rehashing.
      * The default size of the array is 16, so when more than 12 elements (16*0.75) are inserted, the HashMap will resize.
      * During rehashing the bucket size gets doubled and position of all the elements gets recalculated.
      */

      /*
       * If working with a custom class always override the hashCode and equals method for custom sotrage functionality.
       */

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

class Student {
    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * This implementation checks for:
     * <ul>
     *   <li>Reference equality (if both references point to the same object).</li>
     *   <li>Nullity and class type (returns false if the other object is null or not of the same class).</li>
     *   <li>Field equality: compares the {@code id} fields for equality and checks if both {@code name} fields are non-null and reference the same object.</li>
     * </ul>
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        else if(obj == null || this.getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return id == other.getId() && (other.getName() != null && name == other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}



public class HashMapDemo {

    public static int simpleHash(Object obj) {
        if (obj == null) return 0;
        return obj.hashCode();
    }
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

        // * We can provide custom initial size and load factor while creating a new HashMap Object.
        HashMap<Integer, String[]> hs2 = new HashMap<>(20, .6f);
        // * So in this hashmap 20 will be the initial capacity of the internal array, and when it will insert the specific load factor i.e. (20 * .6) = 12 then the hashmap will perform rehashing.

        HashMap<Student, Integer> hs3 = new HashMap<>();

        Student s1 = new Student(1, "ABC");
        Student s2 = new Student(2, "XYZ");
        Student s3 = new Student(3, "PQR");
        Student s4 = new Student(1, "ABC");

        // Demonstrate how hashCode() and equals() affect HashMap key behavior

        // Print hash codes and equality for Student objects with same data but different references
        // Since Student does not override hashCode() and equals(), these are based on object reference (memory address)
        System.out.println("HashCode of s1: " + simpleHash(s1)); // Hash code based on default Object implementation (memory address)
        System.out.println("HashCode of s4: " + simpleHash(s4)); // Different from s1, even though data is same
        System.out.println("s1.equals(s4): " + s1.equals(s4));   // false, as equals() is not overridden, so compares references
        System.out.println("s1.hashCode() == s4.hashCode(): " + (s1.hashCode() == s4.hashCode())); // usually false, as default hashCode() uses memory address

        // Demonstrate with String objects (which override hashCode() and equals())
        // String class overrides hashCode() and equals() to use the actual string value
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println("HashCode of str1: " + simpleHash(str1)); // Same hash code, as String overrides hashCode()
        System.out.println("HashCode of str2: " + simpleHash(str2)); // Same as str1
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true, as String overrides equals() to compare values
        System.out.println("str1.hashCode() == str2.hashCode(): " + (str1.hashCode() == str2.hashCode())); // true, as String hashCode() is value-based

        /*
         * In HashMap, keys are compared using both hashCode() and equals().
         * - For Student, since hashCode() and equals() are not overridden, two objects with same data are treated as different keys.
         * - For String, hashCode() and equals() are overridden to use value, so two strings with same content are treated as the same key.
         * This affects how HashMap stores and retrieves values.
         */

        hs3.put(s1, 76);
        hs3.put(s2, 56);
        hs3.put(s3, 79);
        hs3.put(s4, 92);
        hs3.put(new Student(4, "MNO"), 81);

        // * In case of object as a key the hashcode is generated through memory references to object has the same property but different memory references then two different hash code will be generated.

        // * Here altough s1 Student and s4 Student has all the properties same but as the memory references of those two object are different so the hashcode will also be different.

        // * But in case of string or integer if the values of two key are same then the hashcode will also be same.

        System.out.println(hs3);

        System.out.println(hs3.get(s1));
        
    }
}