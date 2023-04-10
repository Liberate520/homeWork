package service;

import java.io.IOException;

import tree.Tree;

public interface Service<E> {
    E find (String st) throws ClassNotFoundException, IOException;
    Tree<E> sortname();
    Tree<E> sortbirthyear();
    Tree<E> sortchild();
    Tree<E> sortid();
    Tree<E> addhuman(E human, E motherh, E fatherh);
}
