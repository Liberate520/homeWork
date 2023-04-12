package model.tree.interfaces;

import java.util.List;

//import tree.classes.Human;

public interface iTree<E> {

    List<E> getTree();

    List<E> searchPerson(String str);

    void addPerson(E person);

    String treeToString();

}