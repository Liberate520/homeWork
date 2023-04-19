package java_oop_homeWork.src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class FamilyTree {
    private String name;
    private HashSet<Kinsman> family;

    public FamilyTree(String surName, Kinsman kinsman) {
        this.name = surName;
        this.family = new HashSet<Kinsman>(Arrays.asList(kinsman));
        kinsman.setFamily(this);
    }

    public void addParent(Kinsman kinsman, Kinsman parent) {
        kinsman.addParent(parent);
        parent.addScion(kinsman);
        this.family.add(parent);
        parent.setFamily(this);
    }

    public void addScion(Kinsman kinsman, Kinsman scion) {
        kinsman.addScion(scion);
        scion.addParent(kinsman);
        this.family.add(scion);
        scion.setFamily(this);
    }

    public String getName() { return this.name; }

    @Override
    public String toString() {
        return name + " | " + this.family.size() + " членов";
    }

    public HashSet<Kinsman> getFamily() {
        return this.family;
    }

    public void printFamily() {
        for (Kinsman kinsman: family) {
            System.out.println(kinsman.toString());
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
