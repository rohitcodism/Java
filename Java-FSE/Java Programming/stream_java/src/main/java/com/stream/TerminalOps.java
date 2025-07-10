package com.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOps {
    public static void main(String[] args) {
        List<Integer> ls1 = List.of(7, 2, 10, 4, 1, 9, 5, 8, 3, 6);

        // * 1. Collect
        List<Integer> ls2 = ls1.stream().skip(4).collect(Collectors.toList());
        List<Integer> ls3 = ls1.stream().skip(4).toList();
        System.out.println(ls2);

        // * 2. forEach
        ls1.stream().forEach(System.out::println);

        // * 3. reduce: Combines elements to produce a single result
        Optional<Integer> op1 = ls1.stream().reduce(Integer::sum);
        System.out.println(op1.get());

        String user = "Rohit";

        Optional<String> opName = Optional.ofNullable(user);
        System.out.println(opName.orElse("Default User"));

        // * 4. Count
        long cntls = ls1.stream().count();
        System.out.println(cntls);

        // * Short Circuit Operations

        // * anyMatch, allMatch, noneMatch
        boolean b1 = ls1.stream().anyMatch(x -> x%2 == 0);
        System.out.println(b1);

        boolean b2 = ls1.stream().allMatch(x -> x>0);
        System.out.println(b2);

        boolean b3 = ls1.stream().noneMatch(x -> x<0);
        System.out.println(b3);

        // * findAny, findFirst
        System.out.println(ls1.stream().findFirst().orElse(0));
        System.out.println(ls1.stream().findAny().orElse(-1));

        // * Question 1
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Ethan", "Fiona");

        List<String> filteredNames = names.stream().filter(x -> x.length()>3).toList();
        System.out.println(filteredNames);

        // * Squaring and Sorting names
        List<Double> streamNums = ls1.stream().map(x -> Math.pow(x, 2)).sorted().toList();
        System.out.println(streamNums);

        // * Summing Values
        long sum = ls1.stream().reduce(0, Integer::sum); // * Identity works as the starting point or the source of the accumultation function
        System.out.println(sum);

        // * Counting occurences of a character in a string
        String testString = "Hello World!";
        System.out.println(testString.chars().filter(x -> x == 'l').count()); // * .chars() method creates a stream out of a string

        // * Stateful Operations: Knows about all the elements in a stream

        // * Stateless Operations: Doesn't know about all the operation, only knows about the element it is working on

        // * Lazy Operations


    }
}