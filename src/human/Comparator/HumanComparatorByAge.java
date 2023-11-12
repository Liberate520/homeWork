package HomeWork.familyTree.homeWork22_10_23.src.human.Comparator;

import HomeWork.familyTree.homeWork22_10_23.src.human.Human;

import java.time.LocalDate;
import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        LocalDate date1 = o1.getAge();
        LocalDate date2 = o2.getAge();

        return date1.compareTo(date2);
    }
}
