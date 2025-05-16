public interface Animal {
    static int maxCount = 100;
    
    void roar();
    void eat();

    /*
        * Static methods can be added inside interface only after Java 8 
     */
    public static void info(){
        System.out.println("This is a member of the animal kingdom.");
    }

    /*
         * Any method inside an interface is already public
         * A default method can automatically inherited by the class that has implemented this interface.
         * We can access this method through the object of the inherited class.
         * Without manually implementing it in each and every classes.
     */
    default void run(){
        System.out.println("The animal is running.");
    }
}
