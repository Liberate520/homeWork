package HW3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HW3_Task2 {
    private static int collectionSum(ArrayList <Integer>list){
        int sum = 0 ;

        for (int i = 0; i < list.size(); i++) {

            sum += list.get(i);
        }
        return sum;
    }
    private static double arithmeticMean(ArrayList<Integer> list){
        double sum = collectionSum(list);
        double size = list.size();
        return sum/size;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        int listSize = 15;
        for (int i = 0; i < listSize; i++) {
            list.add(rnd.nextInt(20));
        }

        int max = Collections.max(list);
        int min = Collections.min(list);
        double average = arithmeticMean(list);

        System.out.println("Список для анализа: " + list);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Среднее арифметическое: " + average);
    }
}
