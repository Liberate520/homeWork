package study_group.student.comparators;

import study_group.group.GroupItem;
import study_group.student.Student;

import java.util.Comparator;

public class StudentComparatorByName<T extends GroupItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
