package java_oop_homeWork.src.familyTree;

import java_oop_homeWork.src.FamilyTreeItem;
import java_oop_homeWork.src.kinsman.Kinsman;
import java_oop_homeWork.src.kinsman.comparators.KinsmanComparatorByDateBirth;
import java_oop_homeWork.src.kinsman.comparators.KinsmanComparatorByName;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<Kinsman> {
    private String name;
    private TreeSet<E> family;

    public FamilyTree(String surName, E kinsman) {
        this.name = surName;
        this.family = new TreeSet<>(Arrays.asList(kinsman));
        kinsman.setFamily(this);
    }

    public boolean addParent(E kinsman, E parent) {
        if (kinsman.setParent(parent)) {
            parent.addChild(kinsman);
            this.family.add(parent);
            parent.setFamily(this);
            return true;
        }
        return false;
    }

    public boolean addChild(E kinsman, E child) {
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

    public SortedSet<E> getFamily() {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FamilyTree) {
            FamilyTree familyTree = (FamilyTree) obj;
            return name.equals(familyTree.name) && family.equals(familyTree.family);
        }
        return false;
    }

    @Override
    public int hashCode() { return Objects.hash(name, family); }

    @Override
    public Iterator iterator() {
        return family.iterator();
    }

    public List<E> sortByName() {
        return family.stream().sorted(new KinsmanComparatorByName<>()).collect(Collectors.toList());
    }

    public List<E> sortByDateBirth() {
        return family.stream().sorted(new KinsmanComparatorByDateBirth<>()).collect(Collectors.toList());
    }
}
