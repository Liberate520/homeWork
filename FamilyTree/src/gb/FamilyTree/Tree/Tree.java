package gb.FamilyTree.Tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import gb.FamilyTree.Node.RelativeNode.RelativeNode;

public class Tree {
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
}
