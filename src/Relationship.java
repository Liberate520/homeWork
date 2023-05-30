import java.util.List;

class Relationship {
    private Person spouse;
    private Person parent;
    private List<Person> children;

    public Relationship(Person spouse, Person parent, List<Person> children) {
        this.spouse = spouse;
        this.parent = parent;
        this.children = children;
    }

    public Person getSpouse() {
        return spouse;
    }

    public Person getParent() {
        return parent;
    }

    public List<Person> getChildren() {
        return children;
    }


}
