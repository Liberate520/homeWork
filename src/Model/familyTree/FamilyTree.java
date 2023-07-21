package Model.familyTree;

import java.util.List;

import Model.familyTree.iterator.ItemIterator;
import Model.human.comparators.ItemComparatorByAge;
import Model.human.comparators.ItemComparatorByBirthDate;
import Model.human.comparators.ItemComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E>{
    private List<E> itemList;

    public FamilyTree() {
        itemList = new ArrayList<>();
    }

    public void createFamily(E parent1, E parent2, E child) {
        child.createRelatings(parent1, parent2, child);
        if (!itemList.contains(parent1)) {
            itemList.add(parent1);
        }
        if (!itemList.contains(parent2)) {
            itemList.add(parent2);
        }
        if (!itemList.contains(child)) {
            itemList.add(child);
        }
    }

    public boolean addItem(E item) {
        if (!itemList.contains(item)) {
            itemList.add(item);
            return true;
        }
        return false;
    }

    public boolean deleteItem(E item) {
        if (itemList.contains(item)) {
            itemList.remove(item);
            return true;
        }
        return false;
    }

    public E getByName(String name){
        for (E item : itemList) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public String getFamilyTree() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E item : itemList) {
            stringBuilder.append(item);
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ItemIterator<>(itemList);
    }

    public void sortByName() {
        itemList.sort(new ItemComparatorByName<E>());
    }

    public void sortByBirthDate() {
        itemList.sort(new ItemComparatorByBirthDate<E>());
    }

    public void sortByAge() {
        itemList.sort(new ItemComparatorByAge<E>());
    }
}
