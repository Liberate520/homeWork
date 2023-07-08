package study_group.group;

import study_group.student.Student;
import study_group.student.comparators.StudentComparatorByAge;
import study_group.student.comparators.StudentComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyGroup implements Iterable<Student>{
    private List<Student> studentList;

    public StudyGroup() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator(studentList);
    }

    public void sortByName() {
        studentList.sort(new StudentComparatorByName());
    }

    public void sortByAge() {
        studentList.sort(new StudentComparatorByAge());
    }
}