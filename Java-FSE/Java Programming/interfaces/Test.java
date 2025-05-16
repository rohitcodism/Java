public class Test {
    public static void main(String[] args) {
        Cat c1 = new Cat();

        c1.eat();

        System.out.println(Cat.maxCount);

        Animal.info();

        /*
            * * The class that have implemnted the interface doesn't have access to the static method inside interface.

            * * Only the interface can call the static method inside it.
        */ 
        // Cat.info()

        c1.run();
    }
}
