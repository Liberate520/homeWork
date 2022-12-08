package DZ.DZ3;

import java.util.Arrays;

public class Main {

    public static void sortEnd(Integer[] nums) {
        SortComparatorByEnd mySort = new SortComparatorByEnd();
        Arrays.sort(nums, mySort);
    }

    public static void main(String[] args) {
        Integer[] nums = {10, 13, 44, 31, 5, 32, 19, 21, 73};
        Arrays.sort(nums);  // обычная сортировка     

        for (int i : nums) {
            System.out.print(i + " ");
        }

        sortEnd(nums); // сортировка по посл числу
       
        System.out.println();
        for (int i : nums) {
            System.out.print(i + " ");
        }

        ArraysNum arr = new ArraysNum();
        arr.addNums(5);
        arr.addNums(14);
        arr.addNums(21);
        arr.addNums(77);

        System.out.println();
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }
}
