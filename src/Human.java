import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, HumanItem {
    private String name;
    private int birthYear;
    private Human mother;
    private Human father;
    private List<Human> children = new ArrayList<>();
    
    public Human() {

    }

    public Human(String name, int birthYear, Human mother, Human father) {
        this.name = name;
        this.birthYear = birthYear;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, int birthYear) {
        this(name, birthYear, null, null);
    }
    
    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getMother() {
        if (mother != null) {
            return mother.getName();
        } else {
            return "не указана";
        }
    }

    public String getFather() {
        if (father != null) {
            return father.getName();
        } else {
            return "не указан";
        }
    }

    public void addChild(Human human) {
        children.add(human);
    }

    public void showChildren() {
        System.out.println(children.toString());
    }

    public String toString() {
        return "Имя: " + name + ", год рождения: " + birthYear + ", мать: " + getMother() + ", отец: " + getFather();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
