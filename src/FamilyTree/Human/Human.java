package FamilyTree.Human;

import FamilyTree.Human.comparators.GetGroup;
import FamilyTree.Human.other.Gender;
import FamilyTree.Human.interfacee.Create;
import FamilyTree.Human.other.MotFath;

import java.util.List;

public class Human implements Create, GetGroup {
    private int id;
    private Gender gender;
    private int age;
    private String name;
    private String surname;
    private FamilyTree.Human.other.MotFath MotFath;
    private List<String> children;


    public Human(int id, Gender gender, int age, String name, String surname, FamilyTree.Human.other.MotFath motFath, List<String> children) {
        this.gender = gender;
        this.age = age;
        this.name = name;
        this.surname = surname;
        MotFath = motFath;
        this.children = children;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void create() {
        System.out.println("готово");
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", gender=" + gender +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", MotFath=" + MotFath +
                ", children=" + children +
                '}';
    }
}
