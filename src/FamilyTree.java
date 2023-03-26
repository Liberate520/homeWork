import java.util.ArrayList;

public class FamilyTree {
    private ArrayList<Person> people = new ArrayList<>();

    public void addFamilyMember(Person person) {
        this.people.add(person);
    }

    public void setFather(Person person, Person father) {
        person.setFather(father);
        father.addChild(person);
    }

    public void setMother(Person person, Person mother) {
        person.setMother(mother);
        mother.addChild(person);
    }
}
