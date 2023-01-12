import java.util.Comparator;
import java.util.Map;

public class HunamComparatorBySecondName implements Comparator<Map.Entry<String, Human>> {

    @Override
    public int compare(Map.Entry<String, Human> o1, Map.Entry<String, Human> o2) {
        return (o1.getValue().getSecondName()).compareTo(o2.getValue().getSecondName());
    }
}
