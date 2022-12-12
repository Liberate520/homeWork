import java.util.ArrayList;

class GeoTree implements Tree {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getData() {
        return tree;
    }

    public void append(Person p1, Link v1, Link v2, Person p2) {
        tree.add(new Node(p1, v1, p2));
        tree.add(new Node(p2, v2, p1));
        System.out.println(tree);
    }
}