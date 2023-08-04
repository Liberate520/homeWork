package model.service;

import model.familyTree.ConnectionType;
import model.familyTree.Connections;
import model.familyTree.FamilyTree;
import model.familyTree.TreeNode;
import model.readWrite.FileHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Service<T extends TreeNode<T>> implements Iterable<Map.Entry<T, Connections<T>>> {
    private FamilyTree<T> tree;
    private FileHandler fileHandler;

    public Service(FamilyTree<T> familyTree) {
        this.tree = familyTree;
        this.fileHandler = new FileHandler();
    }

    public Service() {
        this(new FamilyTree<>());
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

    public String sortByAge() {
        return tree.sortByAge();
    }

    public String sortByName() {
        return tree.sortByName();
    }

    @Override
    public Iterator<Map.Entry<T, Connections<T>>> iterator() {
        return tree.iterator();
    }

    public String printTree() {
        return tree.toString();
    }

    public ArrayList<T> enumeratedList() {
        ArrayList<T> result = new ArrayList<>();
        for (Map.Entry<T, Connections<T>> pair :
                tree) {
            T item = pair.getKey();
            result.add(item);
        }
        return result;
    }

    public void write() {
        fileHandler.write(tree);
    }

    public void read() {
        this.tree = (FamilyTree<T>) fileHandler.read();
    }
}
