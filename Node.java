import java.util.ArrayList;
import java.util.List;

public class Node {
    private Person data = null;
    private List<Node> children = new ArrayList<>();
    private Node mother = null;
    private Node father = null;

    public Node(Person data) {
        this.data = data;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public void addChild(Person data) {
        this.children.add(new Node(data));
    }

    public void addChildren(List<Node> children) {
        this.children.addAll(children);
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public Person getData() {
        return data;
    }

    public void setData(Person data) {
        this.data = data;
    }

    public void setParent(Node parent) {
        if (parent.data.getData("gender") == "male") {
            this.father = parent;
        }
        else {
            this.mother = parent;
        }
    }

    public Node getParent(String gender) {
        if (gender == "male")
            return this.father;
        else
            return this.mother;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Член семьи:\n");
        sb.append(this.data);
        sb.append("Дети:\n[");
        for (Node item : this.children)
            sb.append(item.getData());
        sb.append("]\n");
        sb.append("Родители:\n");
        sb.append(this.father.getData());
        sb.append(this.mother.getData());
        return sb.toString();
    }

}
