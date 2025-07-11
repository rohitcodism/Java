package com.stream;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 45, 67, 23, 89, 34, 56, 78, 90, 11);
        System.out.println("Numbers: " + numbers);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hannah");

        // * Collecting to a set
        Set<Integer> st1 = numbers.stream().collect(Collectors.toSet()); // * We can collect the stream to either Set or List using Collectors

        // * Collecting to a specific collection
        Deque<Integer> dq1 = numbers.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));


        // * Joining two streams using Collectors
        String joinedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(joinedNames);

        // * Summarizing data using collectors
        IntSummaryStatistics num = numbers.stream().collect(Collectors.summarizingInt(x -> x));


        System.out.println("Average: "+num.getAverage());
        System.out.println("Count: " + num.getCount());
        System.out.println("Sum: " + num.getSum());
        System.out.println("Min: " + num.getMin());
        System.out.println("Max: " + num.getMax());

        System.out.println(numbers.stream().collect(Collectors.averagingInt(x -> x)));
        System.out.println(numbers.stream().collect(Collectors.counting()));
        System.out.println(numbers.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get());
        System.out.println(numbers.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get());

        // * Grouping elements
        System.out.println(names.stream().collect(Collectors.groupingBy(x -> x.length())));
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", "))));
        TreeMap<Integer, String> tm1 = names.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.joining(", ")));

        System.out.println(tm1);

        // * Partitioning Elements
        System.out.println(names.stream().collect(Collectors.partitioningBy(x -> x.length() < 4)));

        // * Mapping -> It is a shorcut that avoids writing .map() seperatly
        System.out.println(names.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.joining(", ")))); 

        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        System.out.println("Words: " + words);

        // * Collecting word ocurrences
        System.out.println(words.stream().collect(Collectors.groupingBy(x->x, Collectors.counting())));


        // * Partititoning odd and event numbers
        System.out.println(numbers.stream().collect(Collectors.partitioningBy(x -> x%2==0)));

        // * Summing values in a map
        Map<String, Integer> itemCounts = new HashMap<>();
        itemCounts.put("apple", 120);
        itemCounts.put("banana", 80);
        itemCounts.put("orange", 45);
        itemCounts.put("grape", 60);
        itemCounts.put("mango", 150);
        itemCounts.put("peach", 30);
        itemCounts.put("kiwi", 10);
        itemCounts.put("pineapple", 100);
        itemCounts.put("pear", 25);
        itemCounts.put("plum", 70);
        System.out.println(itemCounts);

        // * Counting total number of items
        System.out.println(itemCounts.values().stream().reduce(0, Integer::sum));
        System.out.println(itemCounts.values().stream().collect(Collectors.summingInt(x->x)));

        // * Word length using .toMap()
        System.out.println(names.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length())));        
        

        // * Word count using .toMap()
        System.out.println(words.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x->1, (x,y) -> x+y))); // * Merge function is used to handle duplicate keys when duplicate key appears how to handle that situation        
    }
}