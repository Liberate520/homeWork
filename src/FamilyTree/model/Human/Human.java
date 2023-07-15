package FamilyTree.model.Human;

import FamilyTree.model.Human.interfacee.GetGroup;
import FamilyTree.model.Human.other.Gender;
import FamilyTree.model.Human.interfacee.Create;

import java.util.List;

public class Human implements Create, GetGroup {
    private int id;
    private Gender gender;
    private String genderr;
    private int age;
    private String name;
    private String surname;
    private FamilyTree.model.Human.other.MotFath MotFath;


    public Human(int id, int age, String name, String surname, String genderr) {
        this.genderr = genderr;
        this.age = age;
        this.name = name;
        this.surname = surname;
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
                ", gender=" + genderr +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
