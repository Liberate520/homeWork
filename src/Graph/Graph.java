package Graph;

import java.util.*;

public class Graph {
    HashMap<Integer, Node> graph;

    public Graph(ArrayList<int[]> graphData) {
        this.graph = new HashMap<Integer,Node>();
        createGraph(graphData);

    }
    public int getSize(){
        return graph.size();
    }

    public Node getNode(int value) {
        if (value == -1) return null;
        if (this.graph.containsKey(value)) return this.graph.get(value);
        else return null;
    }
    private Node addNode(int value) {
        if (value == -1) return null;
        if (this.graph.containsKey(value)) return this.graph.get(value);
        Node node = new Node(value);
        this.graph.put(value, node);
        return node;

    }

    private void createGraph(ArrayList<int[]> graphData) {
        for (int[] row : graphData) {
            if (row[0]==0) continue;
            Node node = addNode(row[0]);
            Node adjacentNode = addNode(row[1]);
            if (adjacentNode == null) continue;
            Edge edge = new Edge(adjacentNode, row[2]);
            node.edges.add(edge);
            adjacentNode.parents.put(node, edge);

        }
    }

    public List<LinkedHashSet<Node>> getPathAllWrap(Node start, Node end) {
        List<LinkedHashSet<Node>> paths = new ArrayList<>();
        if (start == null) return paths;
        getPathAll(start, end, new LinkedHashSet<>(), paths);
        return paths;
    }

    private void getPathAll(Node start, Node end, LinkedHashSet<Node> passed, List<LinkedHashSet<Node>> paths) {
        if (start == end) {
            paths.add((LinkedHashSet<Node>) passed.clone());
            paths.get(paths.size() - 1).add(end);
        }
        passed.add(start);
        for (Edge edge : start.edges) {
            if (!passed.contains(edge.adjacentNode)) {
                getPathAll(edge.adjacentNode, end, passed, paths);
            }
        }
        passed.remove(start);
    }

    public boolean getPath(Node start, Node end, HashSet<Node> passed, LinkedList<Node> path) {
        if (start == end) {
            path.addFirst(start);
            return true;
        }
        passed.add(start);
        for (Edge edge : start.edges) {
            if (!passed.contains(edge.adjacentNode)) {
                if (getPath(edge.adjacentNode, end, passed, path)) {
                    path.addFirst(start);
                    return true;

                }
            }
        }
        return false;
    }

   private void DFS(Node node, HashSet<Node> passed) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while (stack.size() != 0) {
            node = stack.peek();
            if (!passed.contains(node)) {
                System.out.println(node.value);
                passed.add(node);
            }
            boolean hasChildren = false;
            for (Edge edge : node.edges) {
                if (!passed.contains(edge.adjacentNode)) {
                    stack.push(edge.adjacentNode);
                    hasChildren = true;
                    break;
                }
            }
            if (!hasChildren) stack.pop();
        }

    }

   public void DFSWrap(HashMap<Integer, Node> graph) {
        HashSet<Node> passed = new HashSet<Node>();
        for (Map.Entry<Integer, Node> graphEntry : graph.entrySet()) {
            Node node = graphEntry.getValue();
            if (!passed.contains(node)) DFS(node, passed);
        }
    }

   private void BFS(Node node, HashSet<Node> visitingOrPassed) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        visitingOrPassed.add(node);
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            for (Edge edge : node.edges) {
                if (!visitingOrPassed.contains(edge.adjacentNode)) {
                    queue.addLast(edge.adjacentNode);
                    System.out.println(edge.adjacentNode.value);
                }
            }
        }
    }

   public void BFSWrap(HashMap<Integer, Node> graph) {
        HashSet<Node> visitingOrPassed = new HashSet<>();
        for (Map.Entry<Integer, Node> entry : graph.entrySet()) {
            if (!visitingOrPassed.contains(entry.getValue()))
                BFS(entry.getValue(), visitingOrPassed);
        }
    }

}





























