package person;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int birthYear;
    private Integer deathYear; // Используем Integer, чтобы различать живых и умерших
    private List<Person> children;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name + " (род. " + birthYear + ", см. " + (deathYear != null ? deathYear : "н.в.") + ")";
    }
}
