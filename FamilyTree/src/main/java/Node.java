public class Node {
    Person p1;
    Person p2;
    Link re;

    public Node(Person p1, Link re, Person p2) {
        this.re = re;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", p1, re, p2);
    }
}