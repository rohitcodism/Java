import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GenericContainer gn1 = new GenericContainer();

        gn1.setValue("Hello world");
        System.out.println(gn1.getValue());
    }
}