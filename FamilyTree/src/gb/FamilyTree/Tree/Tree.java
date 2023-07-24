package gb.FamilyTree.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import java.util.Iterator;

import gb.FamilyTree.Node.TreeNodeable;
import gb.FamilyTree.Node.comparators.NodeComparatorByName;
import gb.FamilyTree.Node.comparators.NodeComparatorByParents;
import gb.FamilyTree.Tree.Iterator.NodeIterator;

public class Tree<E extends TreeNodeable<E>> implements Serializable, Iterable<E> {
    protected E root;
    protected ArrayList<E> nodes;

    public Tree() {
        nodes = new ArrayList<>();
    }

    public void addNode(E addingNode, E nodeToBeAdded, Relations relation) {
        this.pushToNodes(nodeToBeAdded);

        if (relation == Relations.ONE_LEVEL) {
            addingNode.addOneLevelCommunication(nodeToBeAdded);
            nodeToBeAdded.addOneLevelCommunication(addingNode);
            nodeToBeAdded.setParents(addingNode.getParents());
        } else {
            addingNode.addParentCommunication(nodeToBeAdded);
            nodeToBeAdded.addChildNode(addingNode);
            nodeToBeAdded.setChilds(addingNode.getOneLevelNodes());
        }
    }

    public void addNode(E root) {
        this.root = root;
        this.nodes.add(root);
    }

    public E getNode(int id) throws NoSuchElementException {
        for (E relativeNode : nodes) {
            if (relativeNode.getId() == id) {
                return relativeNode;
            }
        }

        throw new NoSuchElementException("No element with such id!");
    }

    private void pushToNodes(E node) {
        if (nodes.isEmpty()) {
            root = node;
        }

        nodes.add(node);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (E relativeNode : nodes) {
            builder.append(relativeNode);
            builder.append("\n");
        }

        return builder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator<>(nodes);
    }

    public void sortByName() {
        this.nodes.sort(new NodeComparatorByName<>());
    }

    public void sortByParentsAmount() {
        this.nodes.sort(new NodeComparatorByParents<>());
    }
}
