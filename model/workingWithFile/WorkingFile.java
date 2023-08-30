package model.workingWithFile;

import model.tree.Node;
import model.tree.Tree;

public interface WorkingFile<E extends Tree<E>> {
    String load(String file);
    void remove(Node<E> ob);
    int get(int index);
    int getInd(Node<E> ob);
    void change(Node<E> obOld, Node<E> obNew);

    int getSize();
}
