package familyTree.comparators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class HumanComparatorByBirthday implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        //return o1.getDateBirth().compareTo(o2.getDateBirth());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        return LocalDate.parse(o1.getDateBirth(), formatter).compareTo(LocalDate.parse(o2.getDateBirth(), formatter));
    }
}
