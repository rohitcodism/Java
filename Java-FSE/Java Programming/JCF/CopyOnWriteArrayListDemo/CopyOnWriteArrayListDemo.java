// * CopyOnWriteArrayList is threadsafe alternative of ArrayList. In case of CopyOnWriteArrayList what happens is that when a write operation is performed a new copy of the ArrayList Object is generated and all the modifcation take places in the copied version not in the original version. It is done so that other threads that are reading the arraylist at that moment does not get interrupted due to the modification. And Once the modifcation is stable the modified ArrayList is referenced in place of the previous original ArrayList.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> cp1 = new CopyOnWriteArrayList<>();

        List<String> ls1 = new ArrayList<>();

        ls1.add("Apple");
        ls1.add("Ball");
        ls1.add("Cat");

        for(String item : ls1){
            if(item == "Ball"){
               // ls1.add("Butter"); // * As ArrayList is not threadsafe Collection it will throw an error named -> "java.util.ConcurrentModificationException". That means we cannot modify an ArrayList while reading it simultaneously.
                System.out.println(" Could not Added butter while reading");
            }
        }

        System.out.println(ls1);

        cp1.add(1);
        cp1.add(2);
        cp1.add(3);
        cp1.add(4);

        System.out.println(cp1);

        for(Integer item : cp1){ // * It creates a stable snapshot of the ArrayList for modification. Coz a loop needs a stable snapshot to traverse.
            if(item.intValue() == 3){
                cp1.add(5); // * When there is a modification occurs a new copy of the ArrayList is created and all the modification is done on the copied version.
                System.out.println("Added 5 while reading the CopyOnWriteArrayList.");
            }
        }

        // * Only after the loop ends the modified version is referenced in place of the original version.

        System.out.println(cp1);
    }
}