package tree;

import human.Human;
import human.Relative;
import java.util.ArrayList;

public class Tree {


    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void append(Human parent, Human children) {
        tree.add(new Node(parent, Relative.parent, children));
        tree.add(new Node(children, Relative.children, parent));
    }


}

