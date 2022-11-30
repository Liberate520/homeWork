import java.util.Random;
import java.util.Arrays;

public class Task1 {

    public static void task1(){

        int size = 10;
        Integer [] myArray = new Integer [size];


        for (int i = 0; i < myArray.length; i++){
            myArray[i] = Integer.valueOf(new Random().nextInt(1000));
            System.out.print(myArray[i] + " ");
        }

        Arrays.sort(myArray,new MyComparator());

        System.out.println();
        for (Integer item : myArray){
            System.out.print(item + " ");
        }

    }

}
