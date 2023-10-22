package ru.gb.familyTree.person;
import java.util.Comparator;
public class StartDateComparator implements Comparator<Person>{

    /**
     *
     * 0 (Zero) if both the dates represent the same date in calendar.
     * Positive integer if given date is later than the otherDate.
     * Negative integer if given date is earlier than the otherDate.
     */
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getStartDay().compareTo(o2.getStartDay());
    }
}
