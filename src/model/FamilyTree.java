package java_oop_homeWork.src.model;

import java_oop_homeWork.src.model.display.DisplayInfo;
import java_oop_homeWork.src.model.display.displayObjects.DisplayInfoFamilyTree;
import java_oop_homeWork.src.model.display.displayObjects.DisplayStringObject;
import java_oop_homeWork.src.model.person.Person;
import java_oop_homeWork.src.model.person.comparators.PersonComparatorByName;
import java_oop_homeWork.src.model.person.comparators.PersonComparatorByDateBirth;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree implements Serializable, Iterable<Person>, Comparable<FamilyTree> {
    private String name;
    private TreeSet<Person> family;

    public FamilyTree(String surName, Person kinsman) {
        this.name = surName;
        this.family = new TreeSet<>(Arrays.asList(kinsman));
        kinsman.setFamily(this);
    }

    public boolean addParent(int idKinsman, Person parent) {
        Person kinsman = null;
        for (Person item: family) {
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

    public boolean addChild(int idKinsman, Person child) {
        Person kinsman = null;
        for (Person item: family) {
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
        return new DisplayInfoFamilyTree(new DisplayInfo("\n",""," | ",""), this).prepareForPrint();
    }

    public TreeSet<Person> getFamily() {
        return family;
    }

    private TreeSet<String> familyToStr() {
        TreeSet<String> familyStr = new TreeSet<>();
        for (Person kinsman: family) {
            familyStr.add(kinsman.personToStrWithoutChildren());
        }
        return familyStr;
    }

    public String familyToPrint() {
        StringBuilder sb = new StringBuilder();
        for (String kinsman:familyToStr()) {
            sb.append(new DisplayStringObject(new DisplayInfo(), kinsman).prepareForPrint());
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

    public List<Person> sortByName() {
        return family.stream().sorted(new PersonComparatorByName()).collect(Collectors.toList());
    }

    public List<Person> sortByDateBirth() {
        return family.stream().sorted(new PersonComparatorByDateBirth()).collect(Collectors.toList());
    }

    @Override
    public int compareTo(FamilyTree o) {
        return name.compareTo(o.name);
    }

    public boolean isKinsman(int id) {
        for (Person item: family) {
            if (item.getID() == id) {
                return true;
            }
        }
        return false;
    }
}
