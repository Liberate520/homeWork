import java.util.ArrayList;

public class HumanTree {

    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void appendParentChild(Human parent, Human children) {
        tree.add(new Node(parent, Communication.parent, children));
        tree.add(new Node(children, Communication.children, parent));
    }
}
