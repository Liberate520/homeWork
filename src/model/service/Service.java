package model.service;

import model.familyTree.ConnectionType;
import model.familyTree.Connections;
import model.familyTree.FamilyTree;
import model.familyTree.TreeNode;
import model.readWrite.FileHandler;

import java.util.ArrayList;
import java.util.Map;

public class Service<T extends TreeNode<T>> {
    private FamilyTree<T> tree;
    private FileHandler fileHandler;

    public Service() {
        this.tree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
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

    public String printTreeConnections() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<T, Connections<T>> item:
             tree) {
            sb.append(showConnections(item.getKey())).append("\n");
        }
        if (sb.toString().isBlank())
            return "Список пока пуст. Попробуйте загрузить из файла, или добавить людей.\n";
        return sb.toString();
    }

    public String printTree() {
        if (tree.toString().isBlank())
            return "Список пока пуст. Попробуйте загрузить из файла, или добавить людей.\n";
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
