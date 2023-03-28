package tree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateBirth;
    private List<Human> parents;
    private List<Human> children;

    public Human(String firstName, String lastName, Gender gender, Date dateBirth) {
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
        this.addParent(this);
    }

    @Override
    public String toString() {
        return " имя: " + firstName +
                ", фамилия: " + lastName +
                ", дата рождения: " + dateBirth;

    }

}
