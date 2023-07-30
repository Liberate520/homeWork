package Service;

import Graph.Graph;
import Graph.Node;

import java.util.Iterator;

public class FamilyTreeIterator implements Iterator<Node> {
    Graph graph;
    Node startNode;
    Node endNode;
    Node currentNode;
    public FamilyTreeIterator(Graph graph, Node currentNode){
        this.currentNode= currentNode;
        this.graph=graph;
        this.startNode=graph.getNode(0);
        this.endNode=graph.getNode(graph.getSize());
    }
    @Override
    public boolean hasNext() {
        if (currentNode==null){
            return false;
        }
        return currentNode.getHuman().getId()<=endNode.getHuman().getId();
    }

    @Override
    public Node next() {
        Node tmp = this.currentNode;
        this.currentNode = graph.getNode(this.currentNode.getHuman().getId() + 1);
        return tmp;
    }



}
