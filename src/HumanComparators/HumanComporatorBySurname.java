package HumanComparators;
import java.util.Comparator;

import human.Human;

public class HumanComporatorBySurname implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        return human1.surname.compareTo(human2.surname);
    }
}
