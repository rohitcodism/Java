package com.stream;

import java.util.List;
import java.util.stream.Stream;

/*
 * Interimmidiate Operations -> This operations converts one stream to another stream
 * They are lazy, they doesn't get invoked until a terminal operation is called on them
 */

public class IntOps {
    public static void main(String[] args) {

        // * 1. .filter()
        List<String> ls1 = List.of("Alice", "Alice", "Bob", "Charlie", "Diana", "Ethan");
        Stream<String> filteredStream = ls1.stream().filter(x -> x.endsWith("a"));

        // But the inter-ops will invoke only when a terminal operation is attached
        long cnt = filteredStream.count();
        System.out.println("Number of names end with a: " + cnt);

        // * 2. .map()
        Stream<String>mappedStream = ls1.stream().map(String::toUpperCase);

        // * 3. .sorted()
        Stream<String> sortedStream = ls1.stream().sorted();
        Stream<String> sortedStreamUsingComp = ls1.stream().sorted((a,b) -> b.length()-a.length());

        // * 4. .distinct()
        long count = ls1.stream().filter(x -> x.startsWith("A")).distinct().count();
        System.out.println(count);

        // * 5. .limit()
        System.out.println(Stream.iterate(1, x -> x+1).limit(100));

        // * 6. .skip()
        System.out.println(Stream.generate(() -> 2).skip(10).limit(100).skip(10).count());

    }
}