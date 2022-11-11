import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка. 
// (Collections.max())
// *Реализовать алгоритм сортировки слиянием

public class task_2 {
    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<Integer>();
        inputList.add(90);
        inputList.add(40);
        inputList.add(55);
        inputList.add(21);
        inputList.add(89);
        inputList.add(30);
        System.out.println("Max = " + Collections.max(inputList));
        System.out.println("Min = " + Collections.min(inputList));
        System.out.println("Average = " + getAverage(inputList));
    }

    static int getAverage(List<Integer> inputList) {
        int sum = inputList.stream().mapToInt(Integer::intValue).sum();
        return sum / (inputList.size());
    }
}