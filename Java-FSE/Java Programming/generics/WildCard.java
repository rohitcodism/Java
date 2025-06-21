import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//* Wildcard is only used for read only pusposes. 


public class WildCard {
    void readArray(ArrayList<?> list){
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static double sum(List<? extends Number> numbers){
        double sum = 0;
        for(Number n: numbers){
            sum += n.doubleValue();
        }

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(WildCard.sum(Arrays.asList(1,2,3,4,5, 7.7)));
    }
}