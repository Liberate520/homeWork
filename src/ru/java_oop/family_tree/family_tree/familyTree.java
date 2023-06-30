package ru.java_oop.family_tree.family_tree;

import ru.java_oop.family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class familyTree {
    private List<Human> treeNodes;
    private Human NullHuman;

    public Human getNullHuman() {
        return NullHuman;
    }

    public familyTree() {
        this.treeNodes = new ArrayList<>();
    }

    public List<Human> getTreeNodes() {
        return treeNodes;
    }

    public void addFamilyMember(Human human){
        this.treeNodes.add(human);
    }

    public void printTreeNodes(){
        for (Human h : this.treeNodes){
            System.out.println(h.toString());
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "treeNodes:" + treeNodes +
                '}';
    }
}
