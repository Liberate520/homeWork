import java.util.*;

public class ListNumbers implements Iterable<Number>{
    List<Number> numbers;

    public ListNumbers() {
        numbers = new ArrayList<>();
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public void addElement(int number) {
        Number n = new Number(number);
        numbers.add(n);
    }

    public void sortNumbers() {
        numbers.sort(new Sort());
    }

    @Override
    public Iterator<Number> iterator() {
        return numbers.iterator();
    }
}
