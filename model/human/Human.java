package model.human;
import model.family.Subject;

public class Human implements Comparable<Human>, Subject {
    private int id;
    private String name;
    private String gender;
    private String father;
    private String mother;
    private int birthdate;

    public Human(int id, String name, String gender, String father, String mother, int birthdate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", father='" + father +'\'' +
                ", mother='" + mother +'\'' +
                ", birth date=" + birthdate +
                '}';
    }

    @Override
    public int getAge() {
        return birthdate;
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
