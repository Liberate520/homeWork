package model;

import model.Elements.Human;
import model.Elements.TreeElement;
import model.Tree.GenealogicalTree;

public interface Model<E extends TreeElement> {
    String addElement(String name, int birthday, int deathDay);
    String addChildren(String parent, String child);
    String setFather(String child, String father);
    String setMother(String child, String mother);
    E findTreeElement(String name);
    GenealogicalTree<E> getTreeElementList();

}
