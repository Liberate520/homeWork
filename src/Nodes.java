public class Nodes {

    Persons p1;
    Persons p2;
    Relationships relation;

    public Nodes(Persons p1, Persons p2, Relationships relation) {
        this.p1 = p1;
        this.p2 = p2;
        this.relation = relation;
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, relation, p2);
    }

}
