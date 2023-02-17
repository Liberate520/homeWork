import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class FamilyCell implements Serializable {

    private Person father;
    private Person mother;
    private Person currentPerson;
    private List<Person> children = new LinkedList<>();

    public FamilyCell(Person father, Person mother, Person currentPerson, List<Person> children1) {
        this.father = father;
        this.mother = mother;
        this.currentPerson = currentPerson;
        this.children = children1;
    }
    public FamilyCell() {this( null, null, null, null);}


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
        return children;
    }

    public void setChildren(List<Person> children1) {
        children = children1;
    }

    @Override
    public String toString() {
        return "Family:\n" +
                "father=" + father +
                "mother=" + mother +
                ", \n" + currentPerson +
                "Children=" + children;

    }
}