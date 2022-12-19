package controller;

import model.FamilyConnectionType;
import model.GenealogicalTree;
import model.Tree;
import model.TreeElement;

public class MyController {
    GenealogicalTree<TreeElement> tree;

    public MyController(GenealogicalTree<TreeElement> tree) {
        this.tree = tree;
    }

    public void newTree(){
        tree = new Tree<>();
    }
    public void addElement(TreeElement treeElement){
        tree.addElement(treeElement);
    }
    public void addConnection(String name1, String name2, FamilyConnectionType type) {
        tree.findElement(name1).addConnection(tree.findElement(name2), type);
    }
    public void printElement(String name) {
        System.out.println(tree.findElement(name));
    }
    public void printTree(){
        System.out.println(tree);
    }
}
