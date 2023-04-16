package FamilyTree;

import Human.Human;
import Human.Subject;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree<E extends Subject<E>> implements Iterable<E>, Serializable {
    private List<E> familyTree;

    public List<E> getFamilyTree() {
        return familyTree;
    }

    public FamilyTree(ArrayList<E> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addKin(E h) {
        familyTree.add(h);
        if (this.familyTree.contains(h.getMother())) {
            h.getMother().children.add(h);
        }
        if (this.familyTree.contains(h.getFather())) {
            h.getFather().children.add(h);
        }
    }

    public void removeKin(E h) {
        familyTree.remove(h);
    }

    public E getHuman(String name, String surname) {
        for (E h : this.familyTree) {
            if (name.equals(h.getName()) && surname.equals(h.getSurname())) return h;
        }
        return null;
    }

    public E getHuman(String status) {
        for (E h : this.familyTree) {
            if (status.equals(h.getStatus())) return h;
        }
        return null;
    }

    public HashSet<E> getAllChildren(String name, String surname) {
        E parent = getHuman(name, surname);
        HashSet<E> children = new HashSet<>();
        for (E h : this.familyTree) {
            if ((h.getMother() == parent) || (h.getFather() == parent)) {
                children.add(h);
            }
        }
        return children;
    }

    public E getOldest() {
        LocalDate dateDown = LocalDate.MAX;
        E human = null;
        for (E h : this.familyTree) {
            if (h.getBirthDate().isBefore(dateDown)) {
                dateDown = h.getBirthDate();
                human = h;
            }
        }
        return human;
    }

    public E getYoungest() {
        LocalDate dateUp = LocalDate.MIN;
        E human = null;
        for (E h : this.familyTree) {
            if (h.getBirthDate().isAfter(dateUp)) {
                dateUp = h.getBirthDate();
                human = h;
            }
        }
        return human;
    }

    @Override
    public String toString() {
        String res = "";
        for (E h : familyTree) {
            res += h.toString();
        }
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTree);
    }

    public boolean containsOf(String name, String surname) {
        if (familyTree.contains(this.getHuman(name, surname))) return true;
        else return false;
    }
}
