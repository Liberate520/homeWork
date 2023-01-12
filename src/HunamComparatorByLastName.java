import java.util.Comparator;
import java.util.Map;

public class HunamComparatorByLastName implements Comparator<Map.Entry<String, Human>> {

    @Override
    public int compare(Map.Entry<String, Human> o1, Map.Entry<String, Human> o2) {
        return (o1.getValue().getLastName()).compareTo(o2.getValue().getLastName());
    }
}
