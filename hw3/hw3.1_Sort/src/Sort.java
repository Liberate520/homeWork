import java.util.*;

public class Sort implements Comparator<Number>{
    List<Integer> numbers = new ArrayList<>();
    public void sort() {
        Collections.sort(numbers);
    }

    @Override
    public int compare(Number o1, Number o2) {
        int num1 = o1.getNumber() % 10;
        int num2 = o2.getNumber() % 10;
        return Integer.compare(num1, num2);
    }
}


