// * If we want to store elements in the sorted order then we can use SortedMap.

/*
 * SortedMap is an interface that extends Map.
 * It helps us sorting elements on the basis of key or custom comparator.
 * Tree Map is based on Self Balancing Binary Search Tree or Red Black Tree.
 * TreeMap implements NavigableMap and NavigableMap extends SortedMap
 */

 /*
  * A NavigableMap helps in Navigation Operation like find the closest matching key and retreiving key in key reverse order.
  */

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

class treeMapDemoComparator implements Comparator<String> {
    @Override
    public int compare(String k1, String k2) {
        return Integer.compare(k1.length(), k2.length());
    }
}

class SortedMapDemo{
    public static void main(String[] args) {
        SortedMap<String, Integer> sr1 = new TreeMap<>((a, b) -> b.length() - a.length());
        sr1.put("Rohita", 99);
        sr1.put("Mohitaa", 97);
        sr1.put("Sagaraaa", 86);
        sr1.put("Amitaaaaa", 98);

        System.out.println(sr1);

        System.out.println(sr1.firstKey());
        System.out.println(sr1.lastKey());

        System.out.println(sr1.headMap("Mohitaa")); // * Returns all <K, V> pairs whose keys are strictly lesser than the key passed as a parameter.
        System.out.println(sr1.tailMap("Sagaraaaa")); // * Returns all <K, V> pairs whose keys are strictly greater than the key passed as a paramter according to the comparator

        // * Navigable Map
        NavigableMap<Integer, String> nm1 = new TreeMap<>();

        nm1.put(1, "One");
        nm1.put(4, "Four");
        nm1.put(3, "Three");
        nm1.put(2, "Two");
        nm1.put(5, "Five");

        System.out.println(nm1.lowerKey(4)); // * Returns the greatest key that is strictly lesser than 4.

        System.out.println(nm1.higherKey(4)); // * Returns the least key strictly greater than 4. 

        System.out.println(nm1);
    }
}