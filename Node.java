public class Node<T> {
    private T data = null;
    private List<Node> children = new ArrayList<>();
    private Node mother = null;
    private Node father = null;

    public Node(T data) {
        this.data = data;
    }

    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        Node<T> newChild = new Node<>(data);
        newChild.setParent(this);
        this.children.add(newChild);
    }

    public void addChildren(List<Node> children) {
        for (Node t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }
}
