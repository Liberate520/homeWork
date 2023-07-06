package gb.FamilyTree.Node;

import java.io.Serializable;
import java.util.ArrayList;

public class Node implements Serializable {
    protected static int id;

    static {
        Node.id = 0;
    }

    private ArrayList<Node> parents;
    private ArrayList<Node> oneLevelNodes;
    private ArrayList<Node> childNodes;
    private int uniqId;

    public int getId() {
        return this.uniqId;
    }

    public ArrayList<Node> getParents() {
        return this.parents;
    }

    public ArrayList<Node> getOneLevelNodes() {
        return this.oneLevelNodes;
    }

    public ArrayList<Node> getChilds() {
        return this.childNodes;
    }

    /**
     * Sets a reference to the brother/sister parents object.
     * This allows you to save memory and avoid unnecessary copying between objects.
     * 
     * @param parents - one-level (brother/sister) parents arrayList.
     */
    public void setParents(ArrayList<Node> parents) {
        this.parents = parents;
    }

    public void setChilds(ArrayList<Node> childs) {
        this.childNodes = childs;
    }

    public Node(int id) {
        this.uniqId = id;
        this.parents = new ArrayList<>();
        this.oneLevelNodes = new ArrayList<>();
        this.childNodes = new ArrayList<>();

        this.oneLevelNodes.add(this);
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
     * Adding the received argument to the one-level nodes.
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

    /**
     * Adding the received argument to the child nodes arr.
     * 
     * @param child - child node to add.
     */
    public void addChildNode(Node child) {
        this.childNodes.add(child);
    }

    @Override
    public String toString() {
        return String.format("%d. ", this.uniqId);
    }
}
