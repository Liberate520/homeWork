import java.util.Comparator;
import java.util.Map;

public class HunamComparatorByName<T extends Human> implements Comparator<Map.Entry<String, T>> {

    @Override
    public int compare(Map.Entry<String, T> o1, Map.Entry<String, T> o2) {
        return (o1.getValue().getName()).compareTo(o2.getValue().getName());
    }
}
