package com.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Stream in Java
 * Process collections of data in a functional or declarative manner
 * Simplify data processing
 * Embrace functional programming
 * Improve readability and maintainability
 * Enable Easy Parallelism
 */

 /*
  * What is stream ?
  * A sequence of elements that support various operations
  */

public class StreamMain {
    public static void main(String[] args) {
        // * How to use streams ?
        List<Integer> nums = List.of(1,2,3,4,5,6,7);

        // * Ye hai aam zindagi
        int count = 0;
        for(int i : nums){
            if(i%2 == 0){
                count++;
            }
        }
        System.out.println("Number of even numbers: "+(count));

        // * Ye hai mentos zindagi
        long cnt = nums.stream().filter(x -> x%2==0).count();
        System.out.println("Number of even numbers: "+(cnt));
        // * Here nums.stream() -> source, .filter() -> Interimmidiate Operation, .count() -> terminal operation

        // * Stream creation

        // * 1. From collection
        nums.stream();
        
        // * 2. From Arrays
        int[] points = {1,2,3,4,5};
        IntStream pointStream = Arrays.stream(points);

        // * 3. Directly
        Stream.of(1,2,3,4,5);

        // * 4. Inifinite Stream
        List<Integer> ls1 = Stream.generate(() -> 1).limit(100).collect(Collectors.toList()); // * Inifinite stream of all 1s, also we can set a limit of this stream using .limit() method.
        Stream.iterate(1, x -> x+1); // * It will create a stream of 1,2,3,4....., we can set limit here too.

        Stream.iterate(1, x -> x+1).limit(100).collect(Collectors.toList());
        System.out.println(ls1);


    }
}
