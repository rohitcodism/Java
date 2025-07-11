package com.stream;

import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class PrimitiveStreams {
    public static void main(String[] args) {
        // IntStream example: range and forEach
        IntStream.range(1, 5) // 1 to 4
                .forEach(n -> System.out.print(n + " "));
        System.out.println(); // Output: 1 2 3 4 

        // IntStream.of and sum
        int sum = IntStream.of(1, 2, 3, 4, 5).sum();
        System.out.println("Sum: " + sum); // Output: Sum: 15

        // IntStream.map and average
        IntStream squares = IntStream.rangeClosed(1, 5).map(n -> n * n);
        squares.forEach(n -> System.out.print(n + " ")); // Output: 1 4 9 16 25 
        System.out.println();
        double avg = IntStream.rangeClosed(1, 5).average().orElse(0);
        System.out.println("Average: " + avg); // Output: Average: 3.0

        // DoubleStream example: of and sum
        double dsum = DoubleStream.of(1.5, 2.5, 3.5).sum();
        System.out.println("Double sum: " + dsum); // Output: Double sum: 7.5

        // LongStream example: rangeClosed and reduce
        long product = LongStream.rangeClosed(1, 4).reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product); // Output: Product: 24

        // IntStream.filter and count
        long evenCount = IntStream.rangeClosed(1, 10).filter(n -> n % 2 == 0).count();
        System.out.println("Even count: " + evenCount); // Output: Even count: 5

        // IntStream.summaryStatistics
        IntStream statsStream = IntStream.of(2, 4, 6, 8, 10);
        System.out.println("Summary: " + statsStream.summaryStatistics());
        // Output: Summary: IntSummaryStatistics{count=5, sum=30, min=2, average=6.000000, max=10}

        // IntStream.boxed: Convert IntStream to Stream<Integer>
        IntStream.range(1, 4)
            .boxed()
            .forEach(i -> System.out.print(i.getClass().getSimpleName() + " ")); // Output: Integer Integer Integer 
        System.out.println();

        // DoubleStream.boxed: Convert DoubleStream to Stream<Double>
        DoubleStream.of(1.1, 2.2, 3.3)
            .boxed()
            .forEach(d -> System.out.print(d + " ")); // Output: 1.1 2.2 3.3 
        System.out.println();

        // LongStream.range example
        LongStream.range(5, 8)
            .forEach(l -> System.out.print(l + " ")); // Output: 5 6 7 
        System.out.println();

        // IntStream.generate: Generate random numbers
        IntStream.generate(() -> (int)(Math.random() * 10))
            .limit(5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // IntStream.iterate: Generate a sequence
        IntStream.iterate(2, n -> n + 2)
            .limit(5)
            .forEach(n -> System.out.print(n + " ")); // Output: 2 4 6 8 10 
        System.out.println();

        int[] arr = {1,2,3,4,5};
        IntStream str = Arrays.stream(arr);

    }
}

/*
Notes:
- Primitive Streams: IntStream, LongStream, DoubleStream are specialized streams for primitive types.
- range(start, end): Generates numbers from start (inclusive) to end (exclusive).
- rangeClosed(start, end): Generates numbers from start to end (both inclusive).
- of(...): Creates a stream from given values.
- sum(), average(), min(), max(), count(): Terminal operations for aggregation.
- map(), filter(): Intermediate operations for transformation and filtering.
- reduce(identity, accumulator): Reduces the stream to a single value.
- summaryStatistics(): Returns statistics like count, sum, min, average, max.
*/
