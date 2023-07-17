package family_tree.Model.familyTree;

import java.util.List;

import family_tree.Model.familyTree.iterator.ItemIterator;
import family_tree.Model.human.comparators.ItemComparatorByAge;
import family_tree.Model.human.comparators.ItemComparatorByBirthDate;
import family_tree.Model.human.comparators.ItemComparatorByName;

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

    // public void addChilrenForParentsName(){
    //     for (Human possibleChild : humanList) {
    //         for (Human possibleParent : humanList) {
    //             if ((possibleChild.getMother() != null) && (possibleChild.getMother().getName().equals(possibleParent.getName()))) {
    //                 possibleParent.addChildren(possibleChild);
    //             }
    //             if ((possibleChild.getMother() != null) && (possibleChild.getFather().getName().equals(possibleParent.getName()))) {
    //                 possibleParent.addChildren(possibleChild);
    //             }
    //         }
    //     }
    // }

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

    // public String toTxt() {
    //     StringBuilder stringBuilder = new StringBuilder();
    //     for (Human human : humanList) {
    //         stringBuilder.append(human.toTxt());
    //     }
    //     return stringBuilder.toString();
    // }

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
