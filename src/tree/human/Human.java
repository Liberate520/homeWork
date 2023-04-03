package tree.human;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import tree.interfaces.Saveable;

public class Human implements Saveable {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    private Set<Human> parents;
    private Set<Human> children;
    int index;

    public Human(String firstName, String lastName, Gender gender, LocalDate dateBirth, LocalDate dateDeath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.parents = new TreeSet<>();
        this.children = new TreeSet<>();
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate dateBirth) {
        this(firstName, lastName, gender, dateBirth, null);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNames() {
        return firstName + " " + lastName;
    }

    public Set<Human> getParents() {
        return parents;
    }

    public Set<Human> getChildren() {
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
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(firstName);
        sb.append(", фамилия: ");
        sb.append(lastName);
        sb.append(", дата рождения: ");
        sb.append(dateBirth);
        sb.append(", дети: ");
        sb.append(getChildren());
        return sb.toString();

    }

    public String getDataByNames(String firstName, String lastName) {
        return this.getInfo();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getNames().equals(getNames());
    }

}
