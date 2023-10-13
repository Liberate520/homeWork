package model.human;
import model.family.Subject;

public class Human implements Comparable<Human>, Subject {
    private int id;
    private String name;
    private int age;

    public Human(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
