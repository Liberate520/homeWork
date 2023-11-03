package ru.gb.familyTree.tree;

// import ru.gb.familyTree.exceptions.TreeExceptions;
import ru.gb.familyTree.person.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.io.Serializable;

public class FamilyTree implements Serializable, Iterator<Node<Integer, Person>>, Iterable<Node<Integer, Person>> {
    int index= 0;
    private String family;
    private Person root;
    private List<Node<Integer, Person>> nodeList = new ArrayList<>();

    public FamilyTree(String family, Person root, List<Node<Integer, Person>> nodes) {
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

    public void setNode(List<Node<Integer, Person>> node) {
        this.nodeList = node;
    }

    public boolean addNode(Node<Integer, Person> node){
        Node<Integer, Person> temp = new NodeBuilder().createNode();
        temp.setFamily(node.getFamily()); temp.setId(node.getId());
        temp.setParentOne(node.getParentOne()); temp.setParentTwo(node.getParentTwo());
        temp.setChildren(node.getChildren());
        return nodeList.add(temp);
    }
    public Node<Integer, Person> getObjectById (int id){
        for (Node<Integer, Person> itm: nodeList) {
            if (itm.getId() == id) return itm;
        }
        return null;
    }

    public String getFamily() {
        return family;
    }

    public Person getRoot() {
        return root;
    }

    public List<Node<Integer, Person>> getNode() {
        return nodeList;
    }

    @Override
    public boolean hasNext() {
        return index < nodeList.size();
    }

    @Override
    public Node<Integer, Person> next() {
        return nodeList.get(index++);
    }

    @Override
    public Iterator<Node<Integer, Person>> iterator() {
        return this;
    }
}