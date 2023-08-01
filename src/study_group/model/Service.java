package study_group.model;

public class Service {
    private int idStudent;
    private StudyGroup<Student> group;

    public Service() {
        group = new StudyGroup();
    }

    public void addStudent(String name, int age){
        Student student = new Student(idStudent++, name, age);
        group.addStudent(student);
    }
    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список студентов:\n");

//        Iterator<Student> iterator = group.iterator();
//        while (iterator.hasNext()){
//            Student student = iterator.next();
//            stringBuilder.append(student);
//            stringBuilder.append("\n");
//        }
        for (Student student: group){
            stringBuilder.append(student);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByName(){
        group.sortByName();
    }

    public void sortByAge(){
        group.sortByAge();
    }
}
