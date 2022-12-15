import java.util.Comparator;

public class Sort implements Comparator<ArrayNumbers> {
    @Override
    public int compare(ArrayNumbers o1, ArrayNumbers o2) {
        return Integer.compare(o1.getNumber(),o2.getNumber());
    }
}
