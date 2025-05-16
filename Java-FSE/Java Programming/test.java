import java.util.*;

class Test{

    void reverse(int[] arr){
        for(int i = arr.length - 1;i>= 0;i--){
            System.out.print(arr[i]+"\t");
        }
        System.out.println("\n");
        
        //* For each loop
        /*for(int i : arr){
            System.out.print(arr[i]+"\t");
        }
        System.out.println("\n");*/
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        Test t1 = new Test();
        
        int[] arr = new int[5];

        arr[0] = 2;
        arr[1] = -22;
        arr[2] = -4;
        arr[3] = 7;
        arr[4] = 9;

        int res = Integer.MIN_VALUE;

        for(int i = 0;i<arr.length;i++){
            if(res < arr[i]){
                res = arr[i];
            }
        }

        t1.reverse(arr);

        System.out.println("Max number of the array: "+(res));

        //* Jagged Array
        char[][] array = new char[3][];
        array[0] = new char[2];
        array[1] = new char[3];
        array[2] = new char[2];

        System.out.println("Enter the character array values: ");
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array[i].length;j++){
                String input = sc.nextLine();

                if(!input.isEmpty()){
                    array[i][j] = input.charAt(0);
                }
            }
            System.out.print("\n");
        }

        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array[i].length;j++){
                System.out.print(array[i][j]);
            }
            System.out.print("\n");
        }

        sc.close();
    }
}