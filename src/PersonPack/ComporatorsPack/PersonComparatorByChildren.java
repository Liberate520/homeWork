package PersonPack.ComporatorsPack;

import PersonPack.Person;

import java.util.Comparator;
import java.util.Map;

public class PersonComparatorByChildren implements Comparator<Map.Entry<Integer, Person>> {
    @Override
    public int compare(Map.Entry<Integer, Person> o1, Map.Entry<Integer, Person> o2) {
        return o2.getValue().getChildren().size() - o1.getValue().getChildren().size();
    }
}
