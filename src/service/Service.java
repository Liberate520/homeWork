package service;

import java.io.IOException;

import tree.Tree;

public interface Service<E> {
    Tree<E> get(int n, String st) throws ClassNotFoundException, IOException;
}
