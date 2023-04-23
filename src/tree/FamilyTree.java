package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tree.person.Person;
import tree.person.PersonIterator;
import tree.comporator.PersonComparatorById;
import tree.comporator.PersonComparatorByName;


public class FamilyTree<E extends Person> implements Serializable, Iterable<E> {
    private final List<E> familyTree;

    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }
    public List<E> getFamilyTree() {
        return familyTree;
    }

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void add(E person) {
        this.familyTree.add(person);
    }

    @Override
    public String toString() {
        for (Person item : familyTree) {
            System.out.println(item);
        }
        return " ";
    }

    public void parentsPerson(E person) {
        E mather = null;
        E father = null;
        for (E item : familyTree) {
            if (item.getId() == person.getIdMather()) mather = item;
            if (item.getId() == person.getIdFather()) father = item;
        }
        System.out.printf("Исследуемый объект:\n%s\nМать - %s\nОтец - %s", person, mather, father);
    }

    public void childrensPerson(E person) {
        List<E> childrens = new ArrayList<>();
        for (E item : familyTree) {
            if (item.getIdFather() == person.getId() || item.getIdMather() == person.getId()) {
                childrens.add(item);
            }
        }
        if (childrens.size() > 0) {
            System.out.printf("\nИсследуемый объект:\n%s\nДети объекта:\n", person);
            for (E item : childrens) System.out.print(item);
        } else System.out.printf("\nИсследуемый объект:\n%s\nДетей нет", person);
    }
    @Override
    public Iterator<E> iterator() {

        return new PersonIterator<E>(familyTree);
    }

    public void sortByID() {
        familyTree.sort( new PersonComparatorById());
    }

    public void sortByLastName() {
        familyTree.sort( new PersonComparatorByName());
    }

    public void delPerson(int id) {
        for (E item : this) {
            if (item.getId() == id) {
                getFamilyTree().remove(item);
            }
        }
    }

    public List<E> searchPerson(String lastName) {
        List<E> searchTemp = new ArrayList<>();
        for (E item : familyTree) {
            if (item.getLastname().equals(lastName)) searchTemp.add(item);
        }
        return searchTemp;
    }
}
