package human;

import human.Human;

import java.time.LocalDate;
import java.util.Comparator;

public class ComparatorByBirthDate implements Comparator<Human> {
    @Override
    public int compare (Human o1, Human o2) {
        return o1.getAge(LocalDate, LocalDate).compareTo(o2.getAge(LocalDate, LocalDate));
    }
}
