package ru.gb.familyTree.tree;

// import ru.gb.familyTree.exceptions.TreeExceptions;
import ru.gb.familyTree.person.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.io.Serializable;

public class FamilyTree<E1, E2> implements Serializable, Iterator<Node<Integer, Person>>, Iterable<Node<Integer, Person>> {
    int index= 0;
    private String family;
    private Person root;
    private List<Node<E1, E2>> nodeList = new ArrayList<>();

    public FamilyTree(String family, Person root, List<Node<E1, E2>> nodes) {
        this.setFamily(family);
        this.setRoot(root);
        this.setNode(nodes);
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setRoot(Person root) {
        this.root = root;
    }

    public void setNode(List<Node<E1, E2>> node) {
        this.nodeList = node;
    }

    public void addNode(Node<E1, E2> node){
        Node<E1, E2> temp = new NodeBuilder().createNode();
        temp.setFamily(node.getFamily()); temp.setId(node.getId());
        temp.setParentOne(node.getParentOne()); temp.setParentTwo(node.getParentTwo());
        temp.setChildren(node.getChildren());
        nodeList.add(temp);
    }
    public Node<E1, E2> getObjectById (int id){
        for (Node<E1, E2> itm: nodeList) {
            if ((Integer) itm.getId() == id) return itm;
        }
        return null;
    }

    public String getFamily() {
        return family;
    }

    public Person getRoot() {
        return root;
    }

    public List<Node<E1, E2>> getNode() {
        return nodeList;
    }

    @Override
    public boolean hasNext() {
        return index < nodeList.size();
    }

    @Override
    public Node next() {
        return nodeList.get(index++);
    }

    @Override
    public Iterator<Node<Integer, Person>> iterator() {
        return this;
    }
}