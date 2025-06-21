import java.util.ArrayList;

enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY
}

public class Main {
    public static void main(String[] args) {
        GenericContainer<String> gn1 = GenericContainer.createGenericContainer();

        gn1.setValue("Hello world");
        System.out.println(gn1.getValue());

        GenericContainer<Integer> gn2 = GenericContainer.createGenericContainer();
        gn2.setValue(2);
        System.out.println(gn2.getValue());

        Box<BoxT> box1 = new Box<>();
        box1.setValue(new BoxT());
        System.out.println(box1.getValue());

        //Box<String> box2 = new Box<>();

        Day day = Day.MONDAY;

        //Day dayy = "Monday"; --> Enum is already type safe.

        GenericConstructor gnc1 = new <Integer> GenericConstructor(1);

        GenericConstructor gncs = new <String> GenericConstructor("Hello Brother.");
    }
}