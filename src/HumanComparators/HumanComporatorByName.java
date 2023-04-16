package HumanComparators;
import java.util.Comparator;

import human.Human;

public class HumanComporatorByName implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        return human1.name.compareTo(human2.name);
    }
}
