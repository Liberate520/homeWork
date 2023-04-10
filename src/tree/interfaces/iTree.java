package tree.interfaces;

import java.util.List;

//import tree.classes.Human;

public interface iTree<E> {

    List<E> getTree();

    void addPerson(E person);

}