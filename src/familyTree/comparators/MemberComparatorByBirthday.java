package familyTree.comparators;

import member.Human;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class MemberComparatorByBirthday implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        return LocalDate.parse(o1.getBirthDate(), formatter).compareTo(LocalDate.parse(o2.getBirthDate(), formatter));
    }
}
