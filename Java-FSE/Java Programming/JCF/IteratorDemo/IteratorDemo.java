import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> ls1 = new ArrayList<>();

        ls1.add(7);
        ls1.add(13);
        ls1.add(21);
        ls1.add(42);
        ls1.add(56);

        ls1.forEach(System.out::println);

        // for(int i : ls1){
        //     ls1.removeIf(x -> x==21); // * It will throw a ConcurrentModificationException
        // }

        Iterator<Integer> it1 = ls1.iterator();

        while(it1.hasNext()){
            System.out.println(it1.next());
            if(it1.next().intValue() == 21){
                it1.remove();
            }
        }
    }
}