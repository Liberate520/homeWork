package tree;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;
    private String surname;
    private GregorianCalendar birthdDate;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, String surname, GregorianCalendar gregorianCalendar) {
        this.name = name;
        this.surname = surname;
        this.birthdDate = gregorianCalendar;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getname() {
        return name;
    }

    public String getLastname() {
        return surname;
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
        return " имя: " + name +
                ", фамилия: " + surname +
                ", дата рождения: " + birthdDate.getTime();

    }
}
