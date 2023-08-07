package tree;
import human.Human;
import human.Relative;

public class Node {
    public Human person1;
    public Relative re;
    public Human person2;

    public Node(Human person1, Relative re, Human person2) {
        this.person1 = person1;
        this.re = re;
        this.person2 = person2;
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s>", person1, re, person2);
    }
}