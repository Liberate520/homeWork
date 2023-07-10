package ru.gb.family_tree.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Memberable> implements Serializable, Iterable<T> {
    private int tId;
    private List<T> tList;

    public FamilyTree() {
        tList = new ArrayList<>();
    }

    public void addMember(T member) {
        member.setId(tId++);
        tList.add(member);
    }

    public void removeMember(int id) {
        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).id() == id) tList.remove(i);
        }
    }

    public void getTreeMembers() {
        for (T member : tList) System.out.println(member);
    }

    public void clearTree()       { tList.clear(); }
    public void sortByName()      { tList.sort(new ComparatorByName<T>()); }
    public void sortByBirthDate() { tList.sort(new ComparatorByBirthDate<T>()); }

    @Override
    public Iterator<T> iterator() { return new TreeIterator<T>(tList); }
}
