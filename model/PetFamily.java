package homeWork3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class PetFamily implements Serializable, Comparable<PetFamily> {
    private String name;
    private String gender;
    private int age;
    private PetFamily mother;
    private PetFamily father;
    private List<PetFamily> kids;

    public PetFamily(String name, String gender, int age, PetFamily mother, PetFamily father) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mother = mother;
        this.father = father;
        kids = new ArrayList<>();
    }

    public PetFamily(String name, String gender, int age) {
        this(name, gender, age, null, null);
    }

    public void addKid(PetFamily kid) {
        if (!kids.contains(kid)) {
            this.kids.add(kid);
            if (this.gender == "мужской") {
                kid.father = this;
            } else
                kid.mother = this;
        }
    }

    public String printKids() {
        String res = " Дети: ";
        if (!this.kids.isEmpty()) {
            for (int i = 0; i < kids.size(); i++) {
                res += kids.get(i).name + ",";
            }
        } else
            res += " нет";
        return res;
    }

    @Override
    public String toString() {
        String res = "Имя: " + name + ",\t Пол: " + gender + ", Возраст: " + age;
        if (this.mother != null) {
            res += ", Мать: " + mother.name;
        } else
            res += ", Мать: неизвестна";

        if (this.father != null) {
            res += ", Отец: " + father.name + ",";
        } else
            res += ", Отец: неизвестен,";

        res += printKids();

        return res;
    }

    public String getName() {
        return name;
    }

    public PetFamily getFather() {
        return father;
    }

    public PetFamily getMother() {
        return mother;
    }

    public int getAge() {
        return age;
    }

    /*public void setAge(int age) {
        this.age = age;
    }*/

    @Override
    public int compareTo(PetFamily o) {
        return name.compareToIgnoreCase(o.name);
    }
}