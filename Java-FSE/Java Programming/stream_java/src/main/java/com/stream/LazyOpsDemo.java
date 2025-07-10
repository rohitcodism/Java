package com.stream;

import java.util.List;
import java.util.stream.Stream;

// * Lazy Operations


public class LazyOpsDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve", "Frank");

        Stream<String> nameStream = names.stream().filter(name -> {
            System.out.println("Filtering : "+name);

            return name.length() > 3;
        });

        System.out.println("Before filtering: ");
        List<String> filteredNames = nameStream.toList();
        
        System.out.println(filteredNames);
    }
}