package FamilyTree.model.tree;

import FamilyTree.model.person.comparators.PersonComparatorByAge;
import FamilyTree.model.person.comparators.PersonComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeItem<T>> implements Serializable, Iterable<T>{
    private List<T> personList;

    public FamilyTree(List<T> personList) {
        this.personList = personList;
    }
    public FamilyTree() { this(new ArrayList<>()); }

    public boolean addPerson(T element) {
        if (element == null) {
            System.out.println("null");
            return false;
        }
        if (!personList.contains(element)) {
            personList.add(element);
            if (element.getFather() != null) {
                element.getFather().addChild(element);
            }
            if (element.getMother() != null) {
                element.getMother().addChild(element);
            }
            return true;
        }
        return false;
    }

    public T getByName(String name) {
        for(T person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public String getFamilyTreeInfo() {
        StringBuilder sb = new StringBuilder();
        for (T person : personList) {
            sb.append(person.getPersonInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator<>(personList);
    }

    public void sortByName() {
        personList.sort(new PersonComparatorByName<>());
    }

    public void sortByAge() {
        personList.sort(new PersonComparatorByAge<>());
    }

}
