// * Despite having Java 7, Java 8 is developed focused on minimal coding, more use of functional programming (e.g. Lambda Expressions), though all the oops concepts were still there

// * Functional Interfaces are those interfaces which contains only one abstract method nothing else we can implement them using lambda expression

// * A Predicate is fucntional interface with a boolean valued function

// * A Function is also a functional interface that has only one abstract method in it that is .apply()

// * .identity() method returns same value passed as an argument to this method

// * Consumer just goes by its name it just consume a value but returns void...we can use it for like printing some value.

// * Supplier does not accept any argument but always return something

// * BiPredicate, BiFunction, BiConsumer is nothing but Predicate, Function and Consumer accepting two arguments

// * Using method reference we can use methods without invoking it also it can be used in place of lambda expression

package com.stream;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.Arrays;
import java.util.List;

public class BasicStreamDemo {

    public static void main(String[] args) {
        // * Lambda expressions are nothing but annonymous functions with no name, no
        // return type, no access modifier
        Thread t1 = new Thread(() -> {
            System.out.println("Hello World from t1 thread.");
        });

        t1.run();

        // * Predicate
        Predicate<Integer> isEven = x -> x%2 == 0;

        System.out.println(isEven.test(5));

        // * Function
        Function<Integer, Integer> doubler = x -> x*2;
        Function<Integer, Integer> tripler = x -> x*3;
        System.out.println(doubler.apply(4));

        System.out.println(doubler.andThen(tripler).apply(43)); // * In .andThen() doubler will be applied first and then tripler

        Consumer<List<Integer>> printList = x -> {
            for(int i : x){
                System.out.println(i);
            }
        };

        printList.accept(List.of(1,2,3,4,5,6,7,8,9,10));

        // * Supplier

        Supplier<String> sp1 = () -> "Hello World from suppplier!!";
        System.out.println(sp1.get());

        Predicate<Integer> predicate = x -> x%2 == 0;
        Function<Integer, Integer> function = (x) -> x*x;
        Supplier<Integer> supplier = () -> 52;
        Consumer<Integer> consumer = (x) -> System.out.println(x);
        
        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }

        BiPredicate<Integer, Integer> bp1 = (x,y) -> x<y;
        System.out.println(bp1.test(4, 5));

        BiFunction<Integer, Integer, Integer> bf1 = (x,y) -> x*y;
        System.out.println(bf1.apply(4, 5));

        BiConsumer<Integer, Integer> bc1 = (x,y) -> System.out.println("You gave me " + x + " & "+y);
        bc1.accept(4, 5);

        // * Method Reference
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        nums.forEach(System.out::println);  // * --> Method Reference


    }

}
