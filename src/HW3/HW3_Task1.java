package HW3;

import java.util.ArrayList;
import java.util.Random;

public class HW3_Task1 {

    private static boolean isOdd(Integer num){
        if (num % 2 == 0)
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
        var list = CollectionGenerator.integers(20);
        ArrayList <Integer> newList = new ArrayList();

        System.out.println("Начальный список: " +list);

        for (int i = 0; i < list.size(); i++) {
            if (isOdd(list.get(i))){
                newList.add(list.get(i));
            }
        }

//        for (int i = 0; i < list.size(); i++) {
//            if (isOdd(list.get(i))){
//                list.remove(list.get(i));
//            }
//        }
        System.out.println("Конечный список: " + newList);



    }
}
