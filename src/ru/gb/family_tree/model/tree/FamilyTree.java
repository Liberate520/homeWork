package ru.gb.family_tree.model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Memberable> implements Serializable, Iterable<T> {
    private int memberId;
    private List<T> members;

    public FamilyTree() {
        members = new ArrayList<>();
    }

    public void addMember(T member) {
        member.setId(memberId++);
        members.add(member);
    }

    public void removeMember(int id) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).id() == id) members.remove(i);
        }
    }

    public void clearTree()       { members.clear(); }
    public void sortByName()      { members.sort(new ComparatorByName<T>()); }
    public void sortByBirthDate() { members.sort(new ComparatorByBirthDate<T>()); }

    @Override
    public Iterator<T> iterator() { return new TreeIterator<T>(members); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (T member : members) {
            sb.append(member.toString());
            if (counter < countMembers()) sb.append("\n");
            counter++;
        }
        return sb.toString();
    }

    public int countMembers() { return members.size(); }
}
