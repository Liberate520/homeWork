import java.util.ArrayList;
import java.util.Objects;

public class Relation extends Person {
    private Person marriage;
    private ArrayList<Person> parents = new ArrayList<>();
    private ArrayList<Person> kids = new ArrayList<>();

    public Relation(String fullName, String birthDate, Person marriage, ArrayList<Person> parents,
            ArrayList<Person> kids) {
        super(fullName, birthDate);
        this.marriage = marriage;
        this.parents = parents;
        this.kids = kids;
    }

    public Relation() {
    }

    public Person getMarriage() {
        return this.marriage;
    }

    public void setMarriage(Person marriage) {
        this.marriage = marriage;
    }

    public ArrayList<Person> getParents() {
        return this.parents;
    }

    public void setParents(ArrayList<Person> parents) {
        this.parents = parents;
    }

    public ArrayList<Person> getKids() {
        return this.kids;
    }

    public void setKids(ArrayList<Person> kids) {
        this.kids = kids;
    }

    public void addKid(Person kid) {
        this.kids.add(kid);
    }

    public Relation marriage(Person marriage) {
        setMarriage(marriage);
        return this;
    }

    public Relation parents(ArrayList<Person> parents) {
        setParents(parents);
        return this;
    }

    public Relation kids(ArrayList<Person> kids) {
        setKids(kids);
        return this;
    }

    public String listKids(ArrayList<Person> kids) {
        if (kids.isEmpty()) {
            return "<нет>";
        }
        StringBuilder kidsList = new StringBuilder();
        String suffix = "";
        for (Person person : kids) {
            kidsList.append(suffix);
            suffix = ", ";
            kidsList.append(person.toString());
        }
        return kidsList.toString();
    }

    public String listParents(ArrayList<Person> parents) {
        if (parents.isEmpty()) {
            return "<нет>";
        }
        StringBuilder parentsList = new StringBuilder();
        String suffix = "";
        for (Person person : parents) {
            parentsList.append(suffix);
            suffix = ", ";
            parentsList.append(person.toString());
        }
        return parentsList.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Relation)) {
            return false;
        }
        Relation relation = (Relation) o;
        return Objects.equals(marriage, relation.marriage) && Objects.equals(parents, relation.parents)
                && Objects.equals(kids, relation.kids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marriage, parents, kids);
    }

    @Override
    public String toString() {
        return super.toString() + "\nРодители: " + listParents(parents) + "\nВ браке с: " + (marriage == null ? "<Нет>"
                : marriage) + "\nДети: " + listKids(kids);
    }

}
