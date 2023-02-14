import java.util.LinkedList;
import java.util.List;

public class Family {

    private Person father;
    private Person mother;
    private Person currentPerson;
    private List<Person> Children = new LinkedList<>();

    public Family(Person father, Person mother, Person currentPerson, List<Person> children) {
        this.father = father;
        this.mother = mother;
        this.currentPerson = currentPerson;
        Children = children;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMather() {
        return mother;
    }

    public void setMather(Person mother) {
        this.mother = mother;
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }

    public List<Person> getChildren() {
        return Children;
    }

    public void setChildren(List<Person> children) {
        Children = children;
    }

    @Override
    public String toString() {
        return "Family{" +
                "father=" + father +
                ", mother=" + mother +
                ", currentPerson=" + currentPerson +
                ", Children=" + Children +
                '}';
    }
}