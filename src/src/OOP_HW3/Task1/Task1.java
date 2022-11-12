package OOP_HW3.Task1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        Integer[] toSort = {31, 25,50,66,12,13,84,99,55,87};

        System.out.println( "before :"+ Arrays.toString(toSort));

        SortArray.sortByLastNum(toSort);

        System.out.println("after :"+ Arrays.toString(toSort));
    }
}
