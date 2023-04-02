import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private Person mainPerson;
    private List<Person> persons;

    public FamilyTree(Person person) {
        this.mainPerson = person;
        this.persons = new ArrayList<>();
        this.addPerson(this.mainPerson, true);
    }

    public void addPerson(Person person) {
        addPerson(person, false);
    }

    public void addPerson(Person person, boolean addAllChildren) {
        if (!this.hasPerson(person)) {
            this.persons.add(person);
            person.addToFamilyTree(this);
            if (addAllChildren) {
                this.addChildren(person);
            }
        }
    }

    private void addChildren(Person person) {
        if (person.countChildren() != 0) {
            if (this.hasPerson(person)) {
                for (int i = 0; i < person.countChildren(); i++) {
                    this.addPerson(person.getChildren().get(i), true);
                }
            } else {
                this.addPerson(person, true);
            }
        }
    }

    public boolean hasPerson(Person person) {
        boolean result = false;
        for (Person pers : this.persons) {
            if (pers == person) {
                result = true;
            }
        }
        return result;
    }

    public String toString() {
        return toString(this.mainPerson);
    }

    public String toString(Person person) {
        StringBuilder result = new StringBuilder();
        return toString(result, person, 1);
    }

    private String toString(StringBuilder result, Person person, int iter) {
        result.append(String.format("%s%s|", person.toString(), getSpace(person.toString())));
        if (person.countChildren() > 0) {
            for (int i = 0; i < person.countChildren(); i++) {
                if (i > 0) result.append(String.format("%s", getSpaces(iter)));
                toString(result, person.getChildren().get(i), iter + 1);
            }
        } else {
            result.append("\n");
        }
        return result.toString();
    }

    private String getSpace(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 15 - str.length(); i++) {
            result.append(" ");
        }
        return result.toString();
    }

    private String getSpaces(int iter) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < iter; i++) {
            result.append(String.format("%s|", getSpace("")));
        }
        return result.toString();
    }

    public void save(Writable writable){
        writable.save(this);
    }
}