package FamilyTree;

import Human.Human;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree implements Iterable<Human>, Serializable {
    private List<Human> familyTree;

    public List<Human> getFamilyTree() {
        return familyTree;
    }

    public FamilyTree(ArrayList<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new ArrayList<Human>());
    }

    public void addKin(Human h) {
        familyTree.add(h);
        if (this.familyTree.contains(h.getMother())) {
            h.getMother().children.add(h);
        }
        if (this.familyTree.contains(h.getFather())) {
            h.getFather().children.add(h);
        }
    }

    public void removeKin(Human h) {
        familyTree.remove(h);
    }

    public Human getHuman(String name, String surname) {
        for (Human h : this.familyTree) {
            if (name.equals(h.getName()) && surname.equals(h.getSurname())) return h;
        }
        return null;
    }

    public Human getHuman(String status) {
        for (Human h : this.familyTree) {
            if (status.equals(h.getStatus())) return h;
        }
        return null;
    }

    /*public HashSet<Human.Human> getAllChildren(String name, String surname) {
        Human.Human parent = getHuman(name, surname);
        HashSet<Human.Human> children = new HashSet<>();
        for (Human.Human h : this.familyTree) {
            if ((h.getMother() == parent) || (h.getFather() == parent)) {
                children.add(h);
            }
        }
        return children;
    }*/

    public Human getOldest() {
        LocalDate dateDown = LocalDate.MAX;
        Human human = null;
        for (Human h : this.familyTree) {
            if (h.birthDate.isBefore(dateDown)) {
                dateDown = h.birthDate;
                human = h;
            }
        }
        return human;
    }

    public Human getYoungest() {
        LocalDate dateUp = LocalDate.MIN;
        Human human = null;
        for (Human h : this.familyTree) {
            if (h.birthDate.isAfter(dateUp)) {
                dateUp = h.birthDate;
                human = h;
            }
        }
        return human;
    }

    @Override
    public String toString() {
        String res = "";
        for (Human h : familyTree) {
            res += h.toString();
        }
        return res;
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }

}
