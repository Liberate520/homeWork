package Graph;

import Alive.Human.Human;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Node {
    LinkedHashMap<Node, Edge> parents = new LinkedHashMap<Node, Edge>();
    LinkedHashSet<Edge> edges = new LinkedHashSet<Edge>();
    Human human;
    Node(Human human){

        this.human = human;
    }
    public Human getHuman(){
        return human;
    }

}































