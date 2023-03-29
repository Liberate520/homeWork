import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person extends Human implements Serializable {
    private Person father;
    private Person mother;
    private List<Person> children = new ArrayList<>();

    public Person() {
    }

    public Person(int yearBirth, int yearDeath, String fio, Gender gender, Person father, Person mother) {
        setFio(fio);
        setYearBirth(yearBirth);
        setYearDeath(yearDeath);
        this.father = father;
        this.mother = mother;
        if (!(father == null)) {
            father.addChild(this);
        }
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

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public void addChild(List<Person> children) {
        this.children.addAll(children);
    }

    public String toString() {
        //return getFio() + " - годы жизни(" + getYearBirth() + "-" + getYearDeath() + ")" + "Дети: " + getChildren();
        return getFio() + " - годы жизни(" + getYearBirth() + "-" + getYearDeath() + ")";
    }
}
