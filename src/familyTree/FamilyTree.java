package familyTree;

import person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, FTree {
    private String name;
    private List<Person> persons;

    public FamilyTree(String name) {
        this.setName(name);
        this.persons = new ArrayList<>();
    }

    public FamilyTree(Person person) {
        this(person.getLastName());
        this.addPerson(person, true);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Person> getPersonsList() {
        return this.persons;
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

    public void addPerson(Person person) {
        addPerson(person, false);
    }

    public void addPerson(Person person, boolean isAddAllChildren) {
        if (!this.hasPerson(person)) {
            this.persons.add(person);
            if (isAddAllChildren) {
                this.addChildren(person);
            }
        }
    }

    private void addChildren(Person person) {
        if (this.hasPerson(person)) {
            if (person.countChildren() != 0) {
                for (int i = 0; i < person.countChildren(); i++) {
                    this.addPerson(person.getChildren().get(i), true);
                }
            }
        } else {
            this.addPerson(person, true);
        }
    }

    private boolean hasPerson(Person person) {
        boolean result = false;
        if (this.persons.indexOf(person) != -1) result = true;
        return result;
    }

    public Person findPerson(String firstName){
        for (Person person : this.persons){
            if (person.getFirstName().equals(firstName)){
                return person;
            }
        }
        return null;
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(persons);
    }

    public String toString(String firstName) {
        return toString(this.findPerson(firstName));
    }

    public String toString(Person person) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Members of family %s", this.name));
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
}