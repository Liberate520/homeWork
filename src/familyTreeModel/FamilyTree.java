package familyTreeModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import familyTreeModel.comparator.*;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private ArrayList<T> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<T>();
    }

    public ArrayList<T> getFamilyTree() {
        return familyTree;
    }

    public void add(T child, T mother, T father) {
        familyTree.add(child);
        child.setFather(father);
        child.setMother(mother);
        if (mother != null) {
            mother.getChildren().add(child);
        }
        if (father != null) {
            father.getChildren().add(child);
        }
    }

    public void add(T child, T mother) {
        this.add(child, mother, (T) child.getFather());
    }

    public void add(T child) {
        this.add(child, (T) child.getMother(), (T) child.getFather());
    }

    public T get(String name, String surname) {
        for (int i = 0; i < familyTree.size(); i++) {
            if ((familyTree.get(i).getName()).equals(name)) {
                if (surname != null && !surname.equals("null")) {
                    if ((familyTree.get(i).getSurname()).equals(surname)) {
                        return familyTree.get(i);
                    }
                } else {
                    return familyTree.get(i);
                }

            }
        }
        return null;
    }

    public T get(String name) {
        return this.get(name, null);
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<T>(familyTree);// return familyTree.iterator();
    }

    public void sortByAge() {
        familyTree.sort(new HumanComparatorByAge<T>());
    }

    public void sortByName() {
        familyTree.sort(new HumanComparatorByName<T>());
    }

    @Override
    public String toString() {
        return familyTree.toString();
    }
}
