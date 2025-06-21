import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for(Integer item : list){
            System.out.print(item+" ");
        }
        System.out.println("\n");

        System.out.println("Item at index 4 is: "+list.get(4));

        System.out.println("Size of the array: "+list.size());

        list.add(2, 50);

        list.set(3,100);

        for(Integer item : list){
            System.out.print(item+" ");
        }
        System.out.print("\n");

        ArrayList<Integer> list2 = new ArrayList<>(11);
        System.out.println("Initial Array size after setting initial capacity to 1000: "+list2.size());

        List<String> list3 = Arrays.asList("null", "null2", "null3");

        List<Integer> list4 = new ArrayList<>();
        

        System.out.println("List 2 Class name: "+list2.getClass().getName());
        System.out.println("List 3 Class name: "+list3.getClass().getName());
        System.out.println("List 4 Class name: "+list4.getClass().getName());

        System.out.println("List 1: "+list);

        list.remove(1); //-> TO remove a element at index 1
        list.remove(Integer.valueOf(50)); //-> To remove an element of value 50

        System.out.println("After deletion List 1: "+list);
    }
}
