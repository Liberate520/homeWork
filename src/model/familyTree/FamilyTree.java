package java_oop_homeWork.src.model.familyTree;

import java_oop_homeWork.src.model.human.Human;
import java_oop_homeWork.src.model.human.comparators.HumanComparatorByName;
import java_oop_homeWork.src.model.FamilyTreeItem;
import java_oop_homeWork.src.model.human.comparators.HumanComparatorByDateBirth;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<Human>, Comparable<FamilyTree> {
    private String name;
    private TreeSet<E> family;

    public FamilyTree(String surName, E kinsman) {
        this.name = surName;
        this.family = new TreeSet<>(Arrays.asList(kinsman));
        kinsman.setFamily(this);
    }

    public boolean addParent(int idKinsman, E parent) {
        FamilyTreeItem kinsman = null;
        for (E item: family) {
            if (item.getID() == idKinsman) {
                kinsman = item;
            }
        }
        if (kinsman.setParent(parent)) {
            parent.addChild(kinsman);
            this.family.add(parent);
            parent.setFamily(this);
            return true;
        }
        return false;
    }

    public boolean addChild(int idKinsman, E child) {
        FamilyTreeItem kinsman = null;
        for (E item: family) {
            if (item.getID() == idKinsman) {
                kinsman = item;
            }
        }
        if (child.setParent(kinsman)) {
            kinsman.addChild(child);
            this.family.add(child);
            child.setFamily(this);
            return true;
        }
        return false;
    }

    public String getName() { return this.name; }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" | ");
        sb.append(family.size());
        sb.append(" членов");
        return sb.toString();
    }

    public SortedSet<E> getFamilyName() {
        return this.family;
    }

    public void printFamily() {
        for (E kinsman: family) {
            System.out.println(kinsman.getInfo());
        }
    }

    public void printFamily(List<E> family) {
        for (E kinsman: family) {
            System.out.println(kinsman.getInfo());
        }
    }

    public HashSet<String> getFamily() {
        HashSet<String> familyStr = new HashSet<>();
        for (E kinsman: family) {
            String kinsmanStr = kinsman.getInfo();
            familyStr.add(kinsmanStr);
        }
        return familyStr;
    }

    public String familyToPrint() {
        StringBuilder sb = new StringBuilder();
        for (String kinsman: this.getFamily()) {
            sb.append(kinsman);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FamilyTree) {
            FamilyTree familyTree = (FamilyTree) obj;
            return name.equals(familyTree.name) && family.equals(familyTree.family);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, family);
    }

    @Override
    public Iterator iterator() {
        return family.iterator();
    }

    public List<E> sortByName() {
        return family.stream().sorted(new HumanComparatorByName<>()).collect(Collectors.toList());
    }

    public List<E> sortByDateBirth() {
        return family.stream().sorted(new HumanComparatorByDateBirth<>()).collect(Collectors.toList());
    }

    @Override
    public int compareTo(FamilyTree o) {
        return name.compareTo(o.name);
    }

    public boolean isKinsman(int id) {
        for (E item: family) {
            if (item.getID() == id) {
                return true;
            }
        }
        return false;
    }
}
