package study_group.model;

import java.util.*;

public class StudyGroup <E extends StudyGroupItem> implements Iterable<E> {
    private List<E> studentList;

    public StudyGroup() {
        this.studentList = new ArrayList<>();

    }
    public void addStudent(E student){
        studentList.add(student);
    }
    public void sortByName(){
        studentList.sort(new StudentComparatorByName<>());
    }
    public void sortByAge(){
        studentList.sort(new StudentComparatorByAge<>());
    }
    @Override
    public Iterator<E> iterator() {
        return new StudentIterator<>(studentList);
    }

}
