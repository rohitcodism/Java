package com.stream;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

// * Parallel
/*
 * A parallel stream is a feature in Java 8 (Since Java 8), which allows us parallel processing of stream elements using multithreading, that improves the performance of our code
 * It is used for CPU intensive tasks, large datasets and if tasks are independent
 * We cannot use non-final variables inside lambda expressions it only allows final variables due to thread safety
 * So trading off both the things we can use AomicInteger in parallel streams or in lambda expressions for thread safety
 * Mutation means changing the value of a variable — typically one that lives outside the lambda
 * You only need AtomicInteger (or other thread-safe classes) in a lambda expression in parallel streams when you are modifying shared mutable state
 * Prefer using stream operations (reduce, collect) instead of mutating variables — even with AtomicInteger
 *They are cleaner, more functional, and better optimized
 * Using .sequential() method we can convvert a parallel stream into a sequential stream
 */

public class ParlStreamDemo {
    public static void main(String[] args) {

        List<Integer> testNums = Stream.iterate(1, x -> x + 1).limit(10).toList();

        long startTime = System.currentTimeMillis();
        List<Integer> nums = Stream.iterate(1, x -> x+1).limit(20000).toList();
        List<Long> factNums = nums.stream().map(ParlStreamDemo::factorial).toList();
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken in sequential streams: "+(endTime - startTime) + " ms");
        
        long startTime2 = System.currentTimeMillis();
        List<Integer> nums2 = Stream.iterate(1, x -> x+1).limit(20000).toList();
        List<Long> factNums2 = nums.parallelStream().map(ParlStreamDemo::factorial).toList();
        long endTime2 = System.currentTimeMillis();

        System.out.println("Time taken in parallel streams: "+(endTime2 - startTime2) + " ms");

        int sum = 0;

        // ! testNums.parallelStream().forEach(n -> sum += n); 
        // * It will throw an error because we can only use final variable inside but if we use final variable the value of that variable cannot be changed so we cannot get a sum.

        AtomicInteger sumPlus = new AtomicInteger(0);
        testNums.parallelStream().forEach(x -> sumPlus.addAndGet(x));
        System.out.println("Thread safe sum: "+(sumPlus.get()));

        // * Instead of AtomicInteger we can also use .reduce() with normal Integer also we can use .mapToInt(x -> x).sum() like following, .reduce() and .mapToInt(x -> x).sum() internally they avoid using shared state
        long instantSum = testNums.parallelStream().mapToInt(x -> x).sum();
        System.out.println(instantSum);





    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}