package model.familytree;
import model.human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem> implements Serializable, Iterable<T> {
    private List<T> list;

    public FamilyTree() {
        this.list = new ArrayList<>();
    }

    public boolean addHumanToList(T t) {
        if (this.list.size() < 1 || !(this.list.contains(t))) {
            return this.list.add(t);
        }
        return false;
    }

    public List<T> getList() {
        return list;
    }

    public void changeDataOfHuman() {
        System.out.println("Choose person that need to change: ");

    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator(list);
    }

    public void sortByName() {

    }

    public void sortByLastname() {

    }

    public void sortByAge() {

    }

    public void sortById() {

    }
}
