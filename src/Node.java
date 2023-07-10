import java.util.List;

/**
 * @author Mikhail Latypov
 * class Node будет обозначать связь с нодами: с родителями, детьми и т.д.
 * Семейное древо будет содержать не список людей, а вот этих нод.
 */
import java.util.ArrayList;
import java.util.List;

public class Node {
    private Human human;
    private Node father;
    private Node mother;
    private List<Node> children;

    public Node(Human human, Node father, Node mother) {
        this.human = human;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    // Геттеры и сеттеры

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getMother() {
        return mother;
    }

    public void setMother(Node mother) {
        this.mother = mother;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }
}
