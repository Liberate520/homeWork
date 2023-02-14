import java.util.*;

public class Person {
    private String name;
    private String years_government;
    private Person father;
    private Person mother;
    private List<Person> spouse;
    private List<Person> children;


    public Person(String name, String years_government, Person father, Person mother) {
        this.name = name;
        this.years_government = years_government;
        this.father = father;
        this.mother = mother;
        this.spouse = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return years_government;
    }

    public void setAge(int age) {
        this.years_government = years_government;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getSpouse() {
        return spouse;
    }

    public void addSpou(Person spou) {
        this.spouse.add(spou);
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return name + " Годы правления: " + years_government;
    }
}