package study_group.group;

import study_group.student.comparators.StudentComparatorByAge;
import study_group.student.comparators.StudentComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyGroup<E extends GroupItem> implements Iterable<E> {
    private List<E> studentList;

    public StudyGroup() {
        studentList = new ArrayList<>();
    }
    public void addStudent(E student) {
        if (!studentList.contains(student)) {
            studentList.add(student);
        }
    }
    @Override
    public Iterator<E> iterator() {

        return new StudentIterator<>(studentList);
    }

    public void sortByName() {
        //Collections.sort(studentList);
        studentList.sort(new StudentComparatorByName<>());
    }

    public void sortByAge() {
        //Collections.sort(studentList, new StudentComparatorByAge());
        studentList.sort(new StudentComparatorByAge<>());
    }
}
