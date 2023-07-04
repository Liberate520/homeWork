package gb.FamilyTree.Node;

import java.util.ArrayList;

public class Node {
    protected ArrayList<Node> parents;
    protected ArrayList<Node> oneLevelNodes;

    public Node() {
        this.parents = new ArrayList<>();
        this.oneLevelNodes = new ArrayList<>();
    }

    /**
     * Adding the received argument to the parents list.
     * 
     * @param parent - parent node.
     */
    public void addParentCommunication(Node parent) {
        this.parents.add(parent);
    }

    /**
     * Addint the received argument to the one-level nodes.
     * In this case the oneLevel should be able to get root's parents
     * communications.
     * 
     * @param oneLevel - node to add. This node will have the same parent
     *                 connections as the node to which the addition is being made.
     *                 In fact, it should be perceived as a brother or sister.
     */
    public void addOneLevelCommunication(Node oneLevel) {
        this.oneLevelNodes.add(oneLevel);
    }
}
