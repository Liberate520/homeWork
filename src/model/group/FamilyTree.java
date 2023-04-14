package model.group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.group.Comparators.PersonComparatorByAge;
import model.group.Comparators.PersonComparatorByChildren;
import model.group.Comparators.PersonComparatorByGender;
import model.group.Comparators.PersonComparatorById;
import model.group.Comparators.PersonComparatorByName;
import model.person.NodeTree;

public class FamilyTree<T extends NodeTree<T>> implements Groupable<T>, Serializable {

    private List<T> famyliTree;

    public FamilyTree() {
        famyliTree = new ArrayList<>();
    }

    int id = 0;

    public void addPerson(T t) {
        famyliTree.add(t);
        if (t.getMother() != null)
            t.getMother().addChild(t);

        if (t.getFather() != null)
            t.getFather().addChild(t);
    }

    @Override
    public String toString() {
        return famyliTree.toString();
    }

    public T getPersonByName(String name) {
        T findPerson = null;
        for (int i = 0; i < famyliTree.size(); i++) {
            if (famyliTree.get(i).getName().equals(name)) {
                findPerson = famyliTree.get(i);
            }
        }
        if (findPerson == null)
            System.out.println("Такой человек не найден.");
        return findPerson;
    }

    public void findPerson(String findName) {
        boolean find = false;
        for (int i = 0; i < famyliTree.size(); i++) {
            if (famyliTree.get(i).getName().contains(findName)) {
                System.out.println(famyliTree.get(i));
                find = true;
            }
        }
        if (!find)
            System.out.println("Такой человек не найден.");
    }

    public List<T> getPersonList() {
        return famyliTree;
    }

    public void sortByName() {
        famyliTree.sort(new PersonComparatorByName<T>());
        ;
    }

    public void sortByAge() {
        famyliTree.sort(new PersonComparatorByAge<T>());
    }

    public void sortByGenderd() {
        famyliTree.sort(new PersonComparatorByGender<T>());
        ;
    }

    public void sortByChildren() {
        famyliTree.sort(new PersonComparatorByChildren<T>());

    }

    public void sortById() {
        famyliTree.sort(new PersonComparatorById<T>());
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator<T>(famyliTree);
    }

}
