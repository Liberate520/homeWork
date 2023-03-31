import java.io.Serializable;

public class Node implements Serializable {
    public Node(Person p1, Relation re, Person p2) {
        this.p1 = p1;
        this.re = re;
        this.p2 = p2;
    }

    private Person p1;
    private Relation re;
    private Person p2;

    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, re, p2);
    }

    public Person getP1() {
        return p1;
    }

    public Person getP2() {
        return p2;
    }

    public Relation getRe() {
        return re;
    }

    public void setP1(Person p1) {
        this.p1 = p1;
    }

    public void setP2(Person p2) {
        this.p2 = p2;
    }

    public void setRe(Relation re) {
        this.re = re;
    }
}
