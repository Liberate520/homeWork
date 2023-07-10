import java.util.List;

public class Tree {
    private Node root = null;

    public Tree(Node data) {
        this.root = data;
    }

    public Tree(Person data) {
        this(new Node(data));
    }

    public void addChild(Node child) {
        child.setParent(this.root);
        this.root.addChild(child);;
    }

    public void addChild(Person data) {
        Node newChild = new Node(data);
        newChild.setParent(this.root);
        this.root.addChild(newChild);
    }

    public void addChildren(List<Node> children) {
        for (Node child : children) {
            child.setParent(this.root);
        }
        this.root.addChildren(children);
    }

    public List<Node> getChildren() {
        return this.root.getChildren();
    }

    public void setParent(Node parent) {
        parent.addChild(this.root);
        this.root.setParent(parent);
    }

    public Node getParent(String gender) {
        return this.root.getParent(gender);
    }

    public String toString() {
        return this.root.toString();
    }
}