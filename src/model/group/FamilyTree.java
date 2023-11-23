package model.group;

import model.group.iterator.HumanIterator;
import model.human.Human;
import model.human.comparator.CompareByAge;
import model.human.comparator.CompareByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeItem> implements Serializable, Iterable<E>, TreeItem<E> {
    private List<E> humanList;

    public FamilyTree() {
        humanList = new ArrayList<E>();
    }

    public boolean addHuman(E human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            return true;
        }
        return false;
    }

    public String getInfo() {
        StringBuilder ft = new StringBuilder();
        ft.append("Всего " + humanList.size() + " родственников \n");
        for (E k: humanList) {
            ft.append(k);
            ft.append("\n");
        }
        return ft.toString();
    }

    public void addFirstParent() {
        for (E k: humanList) {
            int fp = k.getHuman_Id();
            for (E l: humanList) {
                if (fp == l.getParent_Id()) {
                    l.setFirstParent(k.getName());
                    k.addChildren(l);
                }
            }
        }
    }

    public String toString() {
        return getInfo();
    }

    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new CompareByName<>());
    }

    public void sortByAge() {
        humanList.sort(new CompareByAge<>());
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public int getParentID() {
        return 0;
    }

    @Override
    public int getHuman_Id() {
        return 0;
    }

    @Override
    public int getFirstParent() {
        return 0;
    }

    @Override
    public int getParent_Id() {
        return 0;
    }
}
