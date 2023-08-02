package model.service;

import model.familyTree.ConnectionType;
import model.familyTree.Connections;
import model.familyTree.FamilyTree;
import model.familyTree.TreeNode;
import model.readWrite.FileHandler;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Service<T extends TreeNode<T>> implements Iterable<Map.Entry<T, Connections<T>>> {
    private FamilyTree<T> tree;
    private FileHandler fh;

    public Service(FamilyTree<T> ft) {
        this.tree = ft;
        this.fh = new FileHandler();
    }

    public Service() {
        this(new FamilyTree<T>());
    }

    public void addPerson(T person) {
        tree.addPerson(person);
    }

    public void oneWayConnection(T connectFrom, ConnectionType key, T connectTo) {
        tree.oneWayConnection(connectFrom, key, connectTo);
    }

    public void putConnection(T connectFrom, ConnectionType key, T connectTo) {
        tree.putConnection(connectFrom, key, connectTo);
    }

    public String showConnections(T person) {
        return tree.showConnections(person);
    }

    public TreeMap<T, Connections<T>> sortByAge() {
        return tree.sortByAge();
    }

    public TreeMap<T, Connections<T>> sortByName() {
        return tree.sortByName();
    }

    @Override
    public Iterator<Map.Entry<T, Connections<T>>> iterator() {
        return tree.iterator();
    }

    public String printTree() {
        return tree.toString();
    }

    public void write() {
        fh.write(tree);
    }

    public void read() {
        this.tree =  (FamilyTree<T>) fh.read();
    }
}
