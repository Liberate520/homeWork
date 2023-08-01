package GenerationTree.Model.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import GenerationTree.Model.Tree.Comparators.TreeItemComparatorByAge;
import GenerationTree.Model.Tree.Comparators.TreeItemComparatorByTreeName;
import GenerationTree.Model.Tree.Comparators.TreeItemComporatorByName;
import GenerationTree.Model.Tree.Iterators.TreeItemIterator;

public class GenerationTree<T extends GenTreeItem> implements Serializable, Iterable<GenTreeItem> {

    private String treeName;
    private List<GenTreeItem> items;

    public GenerationTree(String treeName) {
        this.treeName = treeName;
        this.items = new LinkedList<>();
    }

    public String getTreeName() {
        return this.treeName;
    }

    public GenTreeItem getItemById(int id) {
        for (GenTreeItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Map<Integer, List<GenTreeItem>> getAllChildren(int itemId) {
        return getAllChildren(getItemById(itemId));
    }

    public Map<Integer, List<GenTreeItem>> getAllChildren(GenTreeItem person) {
        Map<Integer, List<GenTreeItem>> generationFiltered = new TreeMap<>();
        Queue<GenTreeItem> queue = new LinkedList<>();
        GenTreeItem earlyItem = null;
        queue.offer(person);
        int step = 0;
        while (!queue.isEmpty()) {
            GenTreeItem currentItem = queue.poll();
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

    public Boolean addOnlyItem(GenTreeItem item) {
        return addItem(item, false);
    }

    public Boolean addItemAndRelatives(GenTreeItem item) {
        return addItem(item, true);
    }

    public Boolean addOnlyItem(List<GenTreeItem> item) {
        return addItems(item, false);
    }

    public Boolean addItemAndRelatives(List<GenTreeItem> persons) {
        return addItems(persons, true);
    }

    public boolean deleteItem(int id) {
        var item = getItemById(id);

        deleteLinksFromRelatives(item.getChildren(), item);
        deleteLinksFromRelatives(item.getParrents(), item);
        return this.items.remove(item);
    }

    public void sortByName() {
        this.items.sort(new TreeItemComporatorByName<>());
    }

    public void sortByAge() {
        Collections.sort(this.items, new TreeItemComparatorByAge<>());
    }

    public void sortOutComparator() {
        this.items.sort(new TreeItemComparatorByTreeName());
    }

    public void reverse() {
        Collections.reverse(this.items);
    }

    public Boolean isOneGeneration(GenTreeItem person1, GenTreeItem person2) {
        var parrents1 = person1.getParrents();
        var parrents2 = person2.getParrents();
        for (GenTreeItem parrent1 : parrents1) {
            for (GenTreeItem parrent2 : parrents2) {
                if (parrent1.equals(parrent2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean contains(GenTreeItem person) {
        return this.items.contains(person);
    }

    public List<GenTreeItem> getItemsWithoutfiltItemAndRelatives(GenTreeItem filtItem) {
        List<GenTreeItem> filteredItems = new ArrayList<>();
        for (GenTreeItem item : this.items) {
            if (!isOneGeneration(item, filtItem) &&
                    !item.equals(filtItem) &&
                    !isRelative(filtItem, item) &&
                    !isUncleOrAunt(filtItem, item)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    @Override
    public Iterator<GenTreeItem> iterator() {
        return new TreeItemIterator<>(items);
    }

    private boolean isUncleOrAunt(GenTreeItem item, GenTreeItem potentialUncleOrAunt) {
        for (GenTreeItem itemParrent : item.getParrents()) {
            if (isOneGeneration(itemParrent, potentialUncleOrAunt))
                return true;
        }
        return false;
    }

    private boolean isRelative(GenTreeItem item, GenTreeItem potentialRelative) {
        return item.isAncestor(potentialRelative) || item.isDescendant(potentialRelative);
    }

    private Boolean addItem(GenTreeItem item, Boolean allRelatives) {
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

    private Boolean addItems(List<GenTreeItem> items, Boolean allRelatives) {
        if (items == null || items.size() == 0) {
            return false;
        }
        for (var item : items) {
            addItem(item, allRelatives);
        }
        return true;
    }

    private static boolean deleteLinksFromRelatives(List<GenTreeItem> list, GenTreeItem item) {
        for (GenTreeItem genTreeItem : list) {
            if (genTreeItem.getChildren().remove(item))
                return true;
            if (genTreeItem.getParrents().remove(item))
                return true;
        }
        return false;
    }
}
