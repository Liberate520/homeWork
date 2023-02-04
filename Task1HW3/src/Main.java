import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Integer[] myArr = {2222, 18,67, 12, 54, 38, 521 };
        Arrays.sort(myArr,new OurComparator());

        for(Integer item : myArr) {
            System.out.print(item + " ");
        }






    }

}
