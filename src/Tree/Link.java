package Tree;

public class Link {
    private final Human people1;
    private final Human people2;
    private final Relations relationType;

    public Link(Human person1, Human person2, Relations relation) {
        this.people1 = person1;
        this.people2 = person2;
        this.relationType = relation;
    }

    public Human getPeople(){
        return this.people1;
    }

    public Human getRelationPeople(){
        return this.people2;
    }

    public Relations getRelationType(){
        return relationType;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s для %s", this.people1.getFirstName()+" "+this.people1.getSurName(),
                this.relationType, this.people2.getFirstName()+" "+this.people2.getSurName());
    }
}
