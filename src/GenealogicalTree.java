import java.util.ArrayList;
import java.util.List;

public class GenealogicalTree {
    private List<Person> personList;

    GenealogicalTree(List<Person> personList) {
        this.personList = personList;
    }

    GenealogicalTree() {
        this(new ArrayList<>());
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    @Override
    public String toString() {
        return "personList = " + personList;
    }
}
