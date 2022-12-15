package FT;

public class Link {
    private Human humanFirst;
    private Human humanSecond;
    private Relation link;

    public Link(Human humanFirst, Human humanSecond, Relation link) {
        this.humanFirst = humanFirst;
        this.humanSecond = humanSecond;
        this.link = link;
    }

    public Human getHumanFirst() {
        return humanFirst;
    }

    public Human getHumanSecond() {
        return humanSecond;
    }

    public Relation getLink() {
        return link;
    }
}
