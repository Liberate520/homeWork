package study_group.student;

public class Student implements Comparable<Student>{
    private long id;
    private String name;
    private int age;

    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
        //        if (this.name > o.name)
//            return 1;
//        if (this.name < o.name)
//            return -1;
//        if (this.name == 0.name)
//            return 0;
    }
}
