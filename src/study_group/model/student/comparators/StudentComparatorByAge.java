package study_group.student.comparators;

import study_group.group.GroupItem;
import study_group.student.Student;

import java.util.Comparator;

public class StudentComparatorByAge<T extends GroupItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        //return Integer.compare(o1.getAge(), o2.getAge());
        return o1.getAge() - o2.getAge();
    }
}
