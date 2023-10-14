package model.human;
import model.family.Subject;

public class Human implements Comparable<Human>, Subject {
    private int id;
    private String name;
    private String father;
    private String mother;
    private int age;

    public Human(int id, String name, String father, String mother, int age) {
        this.id = id;
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", father='" + father +'\'' +
                ", mother='" + mother +'\'' +
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
