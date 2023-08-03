public class Node {
    public Node(Human h1, Relationship rp, Human h2) {
        this.h1 = h1;
        this.rp = rp;
        this.h2 = h2;
    }

    Human h1;
    Relationship rp;
    Human h2;

    @Override
    public String toString() {
        return String.format("<%s %s %s>", h1, rp, h2);
    }
}
