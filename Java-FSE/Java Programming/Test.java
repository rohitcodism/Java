import packages.test.Dog;
import packages.test2.Dogy;
import packages.test.Cat;
import packages.test2.Caty;

public class Test {
    public static void main(String[] args) {
            Dog d1 = new Dog();
            Dogy d2 = new Dogy();

            d1.bark();
            d2.bark();

            Cat c1 = new Cat();
            Caty c2 = new Caty();

            c1.meow();
            c2.meow();
    }
}
