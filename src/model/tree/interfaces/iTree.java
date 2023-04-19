package model.tree.interfaces;

import java.util.List;

public interface iTree<E> {

    List<E> getTree();

    void setTree(List<E> persons);

    List<E> searchPerson(String str);

    void addPerson(E person);

    String treeToString();

}