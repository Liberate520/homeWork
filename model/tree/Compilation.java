package model.tree;

import model.tree.relative.Relative;


import java.util.ArrayList;


public class Compilation<E>  {
    ArrayList<Node<E>> tree;

    public Compilation(Node<E> geoTree) {
        tree = geoTree.getTree();
    }

    private ArrayList<E> search(E p, Relative rel) {
        ArrayList<E> result = new ArrayList<>();
        result.add(p);
        for (Node<E> node : tree) {
            if (node.getPerson1() == p && node.getRe() == rel) {
                result.add((E) node.getPerson2());
            }
        }
        return result;
    }


//TODO пока не реализован данный метод для работы через консоль
    public void printSearch(E p, Relative rel) {
        ArrayList<E> source = search(p, rel);
        System.out.println(source.remove(0).toString() + " " + rel + ":");
        if (source.isEmpty()) {
            System.out.println("Нет информации ");
        }
        for (E person : source) {
            if (rel == Relative.children)
                System.out.println(Relative.parent + " " + person);
            else {
                System.out.println(Relative.children + " " + person);
            }

        }
    }




}