package treeUnits;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class TreeUnit implements Serializable {
    private Gender gender;
    private String name;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    private TreeUnit father;
    private TreeUnit mother;
    private List<TreeUnit> children;

    public TreeUnit(Gender gender, String name, LocalDate dateBirth, LocalDate dateDeath, Human father, Human mother) {
        this.gender = gender;
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.father = father;
        this.mother = mother;
        this.children = null;
    }

    public void addChild(TreeUnit child) {
        if (this.children == null) {
            this.children = new ArrayList<TreeUnit>();
            this.children.add(child);
        }
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public TreeUnit getFather() {
        return father;
    }

    public TreeUnit getMother() {
        return mother;
    }

    public List<TreeUnit> getChildren() {
        return children;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setDateDeath(LocalDate dateDeath) {
        this.dateDeath = dateDeath;
    }

    public void setFather(TreeUnit father) {
        this.father = father;
    }

    public void setMother(TreeUnit mother) {
        this.mother = mother;
    }

    public void setChildren(List<TreeUnit> children) {
        this.children = children;
    }

    public abstract String getInfo();
    public abstract void printFullInfo();
}
