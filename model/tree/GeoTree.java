package model.tree;

import model.tree.relative.Relative;

import java.util.ArrayList;

public class GeoTree<E> implements Tree<E>{
    private ArrayList<Node<E>> tree = new ArrayList<>();



    @Override
    public String toString() {
        return "Записано в файл{" +
                "tree=" + tree +
                '}';
    }

    public ArrayList<Node<E>> getTree() {
        return tree;
    }

    public void append(E parent, E children) {
        tree.add(new Node<E>(parent, Relative.parent, children));
        tree.add(new Node<E>(children, Relative.children, parent));
    }

}
