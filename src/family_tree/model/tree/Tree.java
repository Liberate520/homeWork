package family_tree.model.tree;

import family_tree.model.gender.Gender;
import family_tree.model.person.Person;
import family_tree.model.person.comparators.PersonComparatorByAge;
import family_tree.model.person.comparators.PersonComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Tree<E extends Treeable<E>> implements Serializable, Iterable<E> {
    private final ArrayList<E> persons;

    public Tree(ArrayList<E> persons) {
        this.persons = persons;
    }

    public Tree() {
        this.persons = new ArrayList<>();
    }

    public void add(E person) {
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
        else {
            System.out.println("XXX");
        }
    }

    private void addToParents(E person) {
        if (person.getParents() == null) {
            person.setParents(new ArrayList<>());
        } else {
            for (E parent : person.getParents()) {
                parent.addChild(person);
            }
        }
    }

    private void addToChildren(E person) {
        if (person.getChildren() == null) {
            person.setChildren(new ArrayList<>());
        } else {
            for (E children : person.getChildren()) {
                if (person.getGender() == Gender.Female) {
                    children.addMother(person);
                } else {

                    children.addFather(person);
                }
            }
        }
    }

    private void addPartner(E person) {
        if (person.getPartner() != null) {
            for (E partner : persons) {
                if (partner.getPartner() != null) {
                    if (person.getPartner().equals(partner)) {
                        partner.setPartner(person);
                    }
                }
            }
        }
        if (person.getPartner() == null) {
            for (E partner : persons) {
                if (partner.getPartner() != null) {
                    if (partner.getPartner().equals(person)) {
                        person.setPartner(partner);
                    }
                }
            }
        }
    }

    private void addSiblings(E person) {
        for (E otherPerson : persons) {
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
        for (E person : persons) {
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
        for (E person : persons) {
            stringBuilder.append(person.getInfo());
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<E>(persons);
    }

    public void sortByName() {
        persons.sort(new PersonComparatorByName());
    }

    public void sortByAge() {
        persons.sort(new PersonComparatorByAge());
    }

    public E getPerson(Integer id) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId().equals(id)) {
                return persons.get(i);
            }
        }
        return null;
    }

    public E getPerson(String name) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getName().equals(name)) {
                return persons.get(i);
            }
        }
        return null;
    }

}