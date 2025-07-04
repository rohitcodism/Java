// * A LinkedHashMap extends HashMap and implements Map
/*
 * The main difference between HashMap and LinkedHashMap is that LinkedHashMap maintains the order of insertion among the elements or objects unlike HashMap
 * LinkedHashMap uses a doubly LinkedList to maintain the insertion order. Thats why LinkedHashMap is slower and consumes more memory than HashMap, but if maintaining the order of the <K, V> pairs then it is necessary to use a LinkedHashMap
 */

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> ls1 = new LinkedHashMap<>(14, 0.6f, true);
        ls1.putAll(Map.of(1, "ABC", 2, "DEF", 3, "GHI")); // * In this way we can use .putAll() method in LinkedHashMap and also create a Map object on the fly. But as we have used a Map so insertion order is not guranteed

        // * But if we use .put() method the insertion order is guranteed
        ls1.put(4, "JKL");
        ls1.put(5, "MNO");
        ls1.put(6, "PQR");

        /*
         * {1=ABC, 2=DEF, 3=GHI, 4=JKL, 5=MNO, 6=PQR}
         * {1=ABC, 3=GHI, 2=DEF, 4=JKL, 5=MNO, 6=PQR}
         * So the <K, V> pairs that we inserted through .putAll() method using a Map the insertion order is not guranteed but all the <K, V> pairs that we inserted through .put() have the specific insertion order.
         */
        
        // * Also while we are creating a new LinkedHashMap we can pass a parameter called accessOrder which is by default false, but if we make it true it will keep the least used <K, V> pairs at the starting of the LinkedList so that it can be removed easily if needed. That means it can work like LRU (Least Recently Used) Cache. It can be used in Caching.
        System.out.println(ls1.get(3));
        System.out.println(ls1.get(4));
        System.out.println(ls1.get(2));
        System.out.println(ls1.get(6));

        System.out.println(ls1);
    }    
}