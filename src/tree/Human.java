package tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Human implements Serializable {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateBirth;
    private List<Human> parents;
    private List<Human> children;
    int index;

    public Human(String firstName, String lastName, Gender gender, LocalDate dateBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    public void addChild(Human child) {
        this.children.add(child);
        child.addParent(this);
    }

    @Override
    public String toString() {
        return " имя: " + firstName +
                ", фамилия: " + lastName +
                ", дата рождения: " + dateBirth;

    }

}
