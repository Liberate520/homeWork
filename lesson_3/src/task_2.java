import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка. 
// (Collections.max())
// *Реализовать алгоритм сортировки слиянием

public class task_2 {
    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<Integer>();
        inputList.add(15);
        inputList.add(33);
        inputList.add(20);
        inputList.add(34);
        inputList.add(9);
        inputList.add(12);
        System.out.println(Collections.max(inputList));
        System.out.println(Collections.min(inputList));
        System.out.println(getAverage(inputList));
    }

    static int getAverage(List<Integer> inputList) {
        int sum = inputList.stream().mapToInt(Integer::intValue).sum();
        return sum / (inputList.size());
    }
}
