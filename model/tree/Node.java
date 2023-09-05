package model.tree;
//
//
//import model.tree.relative.Relative;
//
//import java.util.ArrayList;
//
//public class Node<E>{
//    E person;
//    E person1;
//    private Relative re;
//    E person2;
//
//
//    public ArrayList<Node<E>> tree = new ArrayList<>();
//
//    public Node(E person1, Relative re, E person2) {
//
//        this.person1 = person1;
//        this.re = re;
//        this.person2 = person2;
//
//    }
//
//    public Node() {
//        this.person = getPerson();
//    }
//
//    private E getPerson() {
//        return person;
//    }
//
//    public Node(String parent) {
//        parent= (String) person;
//    }
//
//
//    public ArrayList<Node<E>> getTree() {
//        return tree;
//    }
//
//
//    public void append(E parent, E children) {
//        tree.add(new Node<>(parent, Relative.parent, children));
//        tree.add(new Node<>(children, Relative.children, parent));
//    }
//
//
//
//    public E getPerson1() {
//        return (E) person1;
//    }
//
//    public Relative getRe() {
//        return re;
//    }
//
//    public E getPerson2() {
//        return(E) person2;
//    }
//
//
//    public String toString() {
//        return String.format("%s | %s | %s\n", person1, re, person2);
//    }
//
//    public String toFileString() {
//        return String.format("%s ", this.getTree());
//
//
//    }
//
//
//}

import model.tree.relative.Relative;

public class Node<E>{
    E person1;
    Relative rel;
    E person2;

    public Node(E p1, Relative rel, E p2) {
        this.person1 = p1;
        this.rel = rel;
        this.person2 = p2;
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s>", person1, rel, person2);
    }

    public E getPerson1() {
        return (E) person1;
    }

    public Relative getRe() {
        return rel;
    }

    public E getPerson2() {
        return(E) person2;
    }

}