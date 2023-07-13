package family_tree.tree;

import family_tree.gender.Gender;
import family_tree.person.Person;
import family_tree.person.comparators.PersonComparatorByAge;
import family_tree.person.comparators.PersonComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Tree implements Serializable, Iterable<Person> {
    private final ArrayList<Person> persons;


    public Tree(ArrayList<Person> persons) {

        this.persons = persons;
    }

    public Tree() {

        this.persons = new ArrayList<>();
    }

    public void add(Person person) {
        if (person == null) {
            return;
        }
        if (!persons.contains(person)) {
            persons.add(person);
            addToParents(person);
            addToChildren(person);
            addPartner(person);
            addSiblings(person);
        }
    }

    private void addToParents(Person person) {
        for (Person parent : person.getParents()) {
            parent.addChild(person);
        }
    }

    private void addToChildren(Person person) {
        for (Person children : person.getChildren()) {
            if (person.getGender() == Gender.Female) {
                children.addMother(person);
            } else {

                children.addFather(person);
            }
        }
    }

    private void addPartner(Person person) {
        if (person.getPartner() != null) {
            for (Person partner : persons) {
                if (partner.getPartner() != null) {
                    if (person.getPartner().equals(partner)) {
                        partner.setPartner(person);
                    }
                }
            }
        }
        if (person.getPartner() == null) {
            for (Person partner : persons) {
                if (partner.getPartner() != null) {
                    if (partner.getPartner().equals(person)) {
                        person.setPartner(partner);
                    }
                }
            }
        }
    }

    private void addSiblings(Person person) {
        for (Person otherPerson : persons) {
            if (otherPerson.equals(person)) {
                continue;
            }
            if (person.getMother() != null && otherPerson.getMother() != null) {
                if (person.getMother().equals(otherPerson.getMother())) {
                    if (!person.getSiblings().contains(otherPerson)) {
                        person.addSibling(otherPerson);
                    }
                    if (!otherPerson.getSiblings().contains(person)) {
                        otherPerson.addSibling(person);
                    }
                }
            }
            if (person.getFather() != null && otherPerson.getFather() != null) {
                if (person.getFather().equals(otherPerson.getFather())) {
                    if (!person.getSiblings().contains(otherPerson)) {
                        person.addSibling(otherPerson);
                    }
                    if (!otherPerson.getSiblings().contains(person)) {
                        otherPerson.addSibling(person);
                    }
                }
            }
        }
    }


    public void reviseDependencies() {
        for (Person person : persons) {
            addPartner(person);
            addToChildren(person);
            addToParents(person);
            addSiblings(person);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("In the tree: ");
        stringBuilder.append(persons.size());
        stringBuilder.append(" objects:\n\n");
        for (Person person : persons) {
            stringBuilder.append(person.getInfo());
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(persons);
    }

    public void sortByName() {
        persons.sort(new PersonComparatorByName());
    }

    public void sortByAge() {
        persons.sort(new PersonComparatorByAge());
    }

    public Person getPerson(Integer id){
        for (int i = 0; i < persons.size(); i++){
            if (persons.get(i).getId().equals(id)) {
                return persons.get(i);
            }
        }
        return null;
    }

    public Person getPerson(String name){
        for (int i = 0; i < persons.size(); i++){
            if (persons.get(i).getName().equals(name)){
                return persons.get(i);
            }
        }
        return null;
    }

}