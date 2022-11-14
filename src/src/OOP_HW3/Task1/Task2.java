package OOP_HW3.Task1;


import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        CustomCollection<Object> customList = new CustomCollection<>();

        customList.add(4);
        customList.add(8);
        customList.add(15);
        customList.add(16);
        customList.add(23);
        customList.add(42);
        customList.add("STRING");

        for (Object i: customList) {
            System.out.println(i);
        }
        System.out.println(customList.get(3));


    }
}
