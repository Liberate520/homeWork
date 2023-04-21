package java_oop_homeWork.src;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class FamilyTree implements Serializable {
    private String name;
    private HashSet<Kinsman> family;

    public FamilyTree(String surName, Kinsman kinsman) {
        this.name = surName;
        this.family = new HashSet<Kinsman>(Arrays.asList(kinsman));
        kinsman.setFamily(this);
    }

    public boolean addParent(Kinsman kinsman, Kinsman parent) {
        if (kinsman.setParent(parent)) {
            parent.addChild(kinsman);
            this.family.add(parent);
            parent.setFamily(this);
            return true;
        }
        return false;
    }

    public boolean addChild(Kinsman kinsman, Kinsman child) {
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

    public HashSet<Kinsman> getFamily() {
        return this.family;
    }

    public void printFamily() {
        for (Kinsman kinsman: family) {
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
}
