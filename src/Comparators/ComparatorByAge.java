package Comparators;

import Human.Human;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class ComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return (Period.between(o1.getBirthData(), LocalDate.now()).getYears() - Period.between(o2.getBirthData(), LocalDate.now()).getYears());
    }
}
