package study_group.service;

import study_group.group.StudyGroup;
import study_group.student.Student;

public class Service {
    private long id;
    private StudyGroup studyGroup;

    public Service() {
        studyGroup = new StudyGroup();
    }

    public void addStudent(String name, int age){
        Student student = new Student(id++, name, age);
        studyGroup.addStudent(student);
    }

    public String getStudentsInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Студенты:\n");
//        Iterator<Student> iterator = studyGroup.iterator();
//        while (iterator.hasNext()){
//            Student student = iterator.next();
//            stringBuilder.append(student);
//            stringBuilder.append("\n");
//        }
        for (Student student: studyGroup){
            stringBuilder.append(student);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        studyGroup.sortByName();
    }

    public void sortByAge() {
        studyGroup.sortByAge();
    }
}