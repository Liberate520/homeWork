import java.io.DataInputStream;

public class Relation {
    private Human human1;
    private Human human2;
    private Relationship node;

    enum Relationship {
        PARENT,
        CHILDREN,
        MARIAGE
    }

    public Relation(Human human1, Relationship node, Human human2) {
        this.human1 = human1;
        this.node = node;
        this.human2 = human2;
    }

    public Human getHuman1() {
        return human1;
    }

    public Human getHuman2() {
        return human2;
    }

    public Relationship getRelationship() {
        return node;
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s>", human1, node, human2);
    }
}
