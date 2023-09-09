package model.tree;

import java.util.ArrayList;


public class Compilation<E> {
    ArrayList<Node<E>> tree;


    public Compilation(GeoTree<E> geoTree) {
        tree = geoTree.getTree();
    }



    @Override
    public String toString() {
        return "Семейное древо: " +
                 tree +
                "}";
    }


}


