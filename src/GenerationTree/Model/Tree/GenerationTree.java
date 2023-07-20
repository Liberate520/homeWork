package GenerationTree.Model.Tree;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import GenerationTree.Model.Tree.Comparators.TreeItemComparatorByAge;
import GenerationTree.Model.Tree.Comparators.TreeItemComporatorByName;
import GenerationTree.Model.Tree.Iterators.TreeItemIterator;

public class GenerationTree<E extends GenTreeItem<E>> implements Serializable, Iterable<E> {

    private String treeName;
    private List<E> items;

    public GenerationTree(String treeName) {
        this.treeName = treeName;
        this.items = new LinkedList<>();
    }

    public String getTreeName() {
        return this.treeName;
    }

    public E getPersonById(int id) {
        for (E item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Map<Integer, List<E>> getAllChildren(int itemId) {
        return getAllChildren(getPersonById(itemId));
    }

    public Map<Integer, List<E>> getAllChildren(E person) {
        Map<Integer, List<E>> generationFiltered = new TreeMap<>();
        Queue<E> queue = new LinkedList<>();
        E earlyItem = null;
        queue.offer(person);
        int step = 0;
        while (!queue.isEmpty()) {
            E currentItem = queue.poll();
            if (earlyItem != null && isOneGeneration(earlyItem, currentItem)) {
                var children = generationFiltered.get(step);
                children.addAll(currentItem.getChildren());
                generationFiltered.replace(step, children);
            } else if (currentItem.getChildren().size() > 0) {
                generationFiltered.put(++step, currentItem.getChildren());

            }
            queue.addAll(currentItem.getChildren());
            earlyItem = currentItem;
        }
        return generationFiltered;

    }

    public Boolean addOnlyPerson(E item) {
        return addItem(item, false);
    }

    public Boolean addPersonAndRelatives(E item) {
        return addItem(item, true);
    }

    public Boolean addOnlyPersons(List<E> item) {
        return addItems(item, false);
    }

    public Boolean addPersonsAndRelatives(List<E> persons) {
        return addItems(persons, true);
    }

    public void sortByName() {
        this.items.sort(new TreeItemComporatorByName<>());
    }

    public void sortByAge() {
        Collections.sort(this.items, new TreeItemComparatorByAge<>());
    }

    public void sortOutComparator(Comparator<E> outComporator) {
        this.items.sort(outComporator);
    }

    public void reverse() {
        Collections.reverse(this.items);
    }

    public Boolean isOneGeneration(E person1, E person2) {
        var parrents1 = person1.getParrents();
        var parrents2 = person2.getParrents();
        for (E parrent1 : parrents1) {
            for (E parrent2 : parrents2) {
                if (parrent1.equals(parrent2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean contains(E person) {
        return this.items.contains(person);
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeItemIterator<>(items);
    }

    private Boolean addItem(E item, Boolean allRelatives) {
        if (item != null && !this.items.contains(item)) {
            this.items.add(item);
        } else {
            return false;
        }
        if (allRelatives) {
            addItems(item.getParrents(), allRelatives);
            addItems(item.getChildren(), allRelatives);
        }
        return true;
    }

    private Boolean addItems(List<E> items, Boolean allRelatives) {
        if (items == null || items.size() == 0) {
            return false;
        }
        for (var item : items) {
            addItem(item, allRelatives);
        }
        return true;
    }
}
