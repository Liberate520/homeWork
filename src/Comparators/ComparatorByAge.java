package Comparators;

import Family.FamilyMember;
import Human.Human;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class ComparatorByAge<E extends FamilyMember> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return (Period.between(o1.getBirthData(), LocalDate.now()).getYears() - Period.between(o2.getBirthData(), LocalDate.now()).getYears());
    }
}
