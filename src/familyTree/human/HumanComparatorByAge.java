package familyTree.human;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HumanComparatorByAge implements Comparator<Human> {

    private Map<String, Human> map;

    public HumanComparatorByAge(Map<String, Human> map) {
        this.map = new HashMap<>(map);
    }

    @Override
    public int compare(Human o1, Human o2) {
        Integer age1 = o1.getAge();
        Integer age2 = o2.getAge();
        return age1.compareTo(age2);
    }
}
