package OOP_HW3;

import java.util.Arrays;
import java.util.Comparator;

public class SortArray  {



    public static void sortByLastNum(Integer[] unsortedArray){
        Integer[] res = new Integer[unsortedArray.length];
        Arrays.sort(unsortedArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                if ((num1%10 > num2%10))
                    return 1;
                else if (num1%10 == num2%10)
                    return 0;
                else return -1;
            }
        });
    }
}
