package gb.FamilyTree.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import java.util.Iterator;

import gb.FamilyTree.Node.RelativeNode.RelativeNode;
import gb.FamilyTree.Tree.Iterator.NodeIterator;

public class Tree implements Serializable, Iterable<RelativeNode> {
    protected RelativeNode root;
    protected ArrayList<RelativeNode> nodes;

    public Tree() {
        nodes = new ArrayList<>();
    }

    public void addNode(RelativeNode addingNode, RelativeNode nodeToBeAdded, Relations relation) {
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

    public void addNode(RelativeNode root) {
        this.root = root;
        this.nodes.add(root);
    }

    public RelativeNode getNode(int id) throws NoSuchElementException {
        for (RelativeNode relativeNode : nodes) {
            if (relativeNode.getId() == id) {
                return relativeNode;
            }
        }

        throw new NoSuchElementException("No element with such id!");
    }

    private void pushToNodes(RelativeNode node) {
        if (nodes.isEmpty()) {
            root = node;
        }

        nodes.add(node);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (RelativeNode relativeNode : nodes) {
            builder.append(relativeNode);
            builder.append("\n");
        }

        return builder.toString();
    }

    @Override
    public Iterator<RelativeNode> iterator() {
        return new NodeIterator(nodes);
    }
}
