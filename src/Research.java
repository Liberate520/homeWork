import Model.Child;
import Model.Human;
import Model.Parent;

import java.util.List;

public class Research {
    private List<Human> people;

    public Research(List<Human> people) {
        this.people = people;
    }
    public Human findPerson(String firstName, String lastName) {
        for (Human person : people) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }
    public Human findPerson(String name) {
        String[] result = name.split(" ");
        return findPerson(result[0], result[1]);
    }

    public void whoYourChildren(String name) {
        ((Parent)findPerson(name)).whoYourChildren();
    }
    public void whoYourMother(String name) {
        ((Child)findPerson(name)).whoYourMother();
    }
    public void whoYourFather(String name) {
        ((Child) findPerson(name)).whoYourFather();
    }
}
