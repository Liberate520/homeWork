package Tree;

public class Communications {
    /**
     * Creates a new instance of a Communications instance with the given name and value
     */
    private final Person people1;
    private final Person people2;
    private final Relations relationType;

    public Communications(Person person1, Person person2, Relations relation) {
        this.people1 = person1;
        this.people2 = person2;
        this.relationType = relation;
    }

    public Person getPeople(){
        return this.people1;
    }

    public Person getRelationPeople(){
        return this.people2;
    }

    public Relations getRelationType(){
        return relationType;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %s for %s %s", getPeople().getFirstName()+" "+getPeople().getSurName(),
                getPeople().getPatronymic(), getRelationType(), getRelationPeople().getFirstName()
                        + " " + getRelationPeople().getSurName(),getRelationPeople().getPatronymic());
    }
}
