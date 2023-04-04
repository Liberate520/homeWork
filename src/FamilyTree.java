import java.io.*;
import java.time.LocalDate;
import java.util.HashSet;

public class FamilyTree implements Serializable {
    HashSet<Human> familyTree;

    public FamilyTree(HashSet<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new HashSet<>());
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

    /*public HashSet<Human> getAllChildren(String name, String surname) {
        Human parent = getHuman(name, surname);
        HashSet<Human> children = new HashSet<>();
        for (Human h : this.familyTree) {
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

}
