import java.util.Comparator;
import java.util.List;

public class MySort implements Comparator<Integer> {

    // метод принимающий массив для сортировки
    public void lastDigitSort (List <Integer> inArray) {
        //сортируем с использованием компоратора
        inArray.sort(new MySort());
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 % 10 > o2 %10) return 1;
        if (o1 % 10 < o2 %10) return -1;
        return 0;
    }
}
