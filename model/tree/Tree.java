package model.tree;

import java.util.ArrayList;

public interface Tree<E> {
    ArrayList<Node<E>> getTree();

    void append(E parent, E children);


}