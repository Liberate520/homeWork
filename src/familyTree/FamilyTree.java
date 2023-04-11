package familyTree;

import member.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FamilyTree<E extends Member> implements Serializable, FTree<E> {
    private String name;
    private List<E> persons;

    public FamilyTree(String name) {
        this.setName(name);
        this.persons = new ArrayList<>();
    }

    public FamilyTree(E person) {
        this(person.getLastName());
        this.addPerson(person, true);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<E> getPersonsList() {
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

    public void addPerson(E person) {
        addPerson(person, false);
    }

    public void addPerson(E person, boolean isAddAllChildren) {
        if (!this.hasPerson(person)) {
            this.persons.add(person);
            if (isAddAllChildren) {
                this.addChildren(person);
            }
        }
    }

    private void addChildren(E person) {
        if (this.hasPerson(person)) {
            if (person.countChildren() != 0) {
                for (E pers : (List<E>) person.getChildren()) {
                    this.addPerson(pers, true);
                }
            }
        } else {
            this.addPerson(person, true);
        }
    }

    private boolean hasPerson(E person) {
        boolean result = false;
        if (this.persons.indexOf(person) != -1) result = true;
        return result;
    }

    public E findPerson(String firstName){
        for (E person : this.persons){
            if (person.getFirstName().equals(firstName)){
                return person;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator(persons);
    }

    public void printInfo() {
        for (E person : this.persons) {
            System.out.println(person);
        }
    }

    public String toString(String firstName) {
        return toString(this.findPerson(firstName));
    }

    public String toString(E person) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Members of family %s", this.name));
        return toString(result, person, 1);
    }

    private String toString(StringBuilder result, E person, int iter) {
        result.append(String.format("%s%s|", person.toString(), getSpace(person.toString())));
        if (person.countChildren() > 0) {
            ListIterator<E> children = ((List<E>) person.getChildren()).listIterator();
            while (children.hasNext()){
                if (children.nextIndex() > 0) result.append(String.format("%s", getSpaces(iter)));
                toString(result, children.next(), iter + 1);
            }
        } else {
            result.append("\n");
        }
        return result.toString();
    }
}