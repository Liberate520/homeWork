import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private LocalDate date;
    private Gender gender;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String name, LocalDate date, Gender gender, Person mother, Person father) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Person(String name, LocalDate date, Gender gender) {
        this(name, date, gender, null, null);
    }

    @Override
    public String toString() {
        return name + " (" + date + ", " + gender + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void addChild(Person person) {
        children.add(person);
    }

    public List<Person> getParents() {
        List<Person> parentsList = new ArrayList<>();
        parentsList.add(mother);
        parentsList.add(father);
        return parentsList;
    }

}