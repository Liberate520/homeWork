package model;

import model.Elements.Human;
import model.Elements.TreeElement;
import model.Tree.FromTo;
import model.Tree.FromToSerializeFile;
import model.Tree.GenealogicalTree;

public interface Model<E extends TreeElement> {
    String addElement(String name, int birthday, int deathDay);
    String addChildren(String parent, String child);
    String setFather(String child, String father);
    String setMother(String child, String mother);
    E findTreeElement(String name);
    GenealogicalTree<E> getTreeElementList();
    String connectPerson(String nameElement, String nameHuman);
    String save(String fileName);
    String load(String fileName);
    void sort();
}
