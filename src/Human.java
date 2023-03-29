package HW_1;

import java.util.Date;
import java.util.List;

public class Human {
    Human mother;
    Human father;
    List<Human> children;
    String name;
    String lastName;
    Sex sex;
    Date birthday;

    public Human(Human mother, Human father, List<Human> children,
                 String name, String lastName, Sex sex, Date birthday) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.birthday = birthday;
    }

    public Human(String name, String lastName, Sex sex) {
        this.mother = null;
        this.father = null;
        this.children = null;
        this.birthday = null;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;

    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "\nHuman : " +
                " mother = " + mother +
                " father = " + father +
                " children = " + children +
                " name = " + name +
                " lastName = " + lastName +
                " sex = " + sex +
                " birthday = " + birthday ;
    }
}
enum Sex {
    male,female
}
