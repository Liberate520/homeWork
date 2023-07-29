package Graph;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Node {
    int value;
    LinkedHashMap<Node, Edge> parents = new LinkedHashMap<Node, Edge>();
    LinkedHashSet<Edge> edges = new LinkedHashSet<Edge>();
    Node(int value){
        this.value = value;
    }
    public int getId(){
        return value;
    }
}































