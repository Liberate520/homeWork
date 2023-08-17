package tree;

import human.Human;
import relative.Relative;

import java.util.ArrayList;

public class Node {
    Human person1;
    private Relative re;
    Human person2;


    public ArrayList<Node> tree = new ArrayList<>();

    public Node(Human person1, Relative re, Human person2) {

        this.person1 = person1;
        this.re = re;
        this.person2 = person2;

    }





    public Node() {

    }

    public Human Node(Human human) {
        return human;
    }


    public ArrayList<Node> getTree() {
        return tree;
    }


    public void append(Human parent, Human children) {
        tree.add(new Node(parent, Relative.parent, children));
        tree.add(new Node(children, Relative.children, parent));
    }



    public Relative getRe() {
        return re;

    }


}