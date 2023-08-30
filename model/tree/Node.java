package model.tree;


import model.tree.relative.Relative;

import java.util.ArrayList;

public class Node<E extends Tree<E>>{
    E person1;
    private Relative re;
    E person2;


    public ArrayList<Node<E>> tree = new ArrayList<>();

    public Node(E person1, Relative re, E person2) {

        this.person1 = person1;
        this.re = re;
        this.person2 = person2;

    }

    public Node() {
        this.person1 = getPerson1();
    }


    public ArrayList<Node<E>> getTree() {
        return tree;
    }


    public void append(E parent, E children) {
        tree.add(new Node<>(parent, Relative.parent, children));
        tree.add(new Node<>(children, Relative.children, parent));
    }



    public E getPerson1() {
        return person1;
    }

    public Relative getRe() {
        return re;
    }

    public E getPerson2() {
        return person2;
    }


    public String toString() {
        return String.format("<%s | %s | %s>\n", person1.getFullName(), re, person2.getFullName());
    }

    public String toFileString() {
        return String.format("%s ", this.getTree());


    }

}