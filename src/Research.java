import Model.Child;
import Model.Human;
import Model.Parent;

import java.util.List;

public class Research {
    private final List<Human> people;

    public Research(List<Human> people) {
        this.people = people;
    }
    protected Human findPerson(String firstName, String lastName, String className) throws ClassNotFoundException {
        Class myClass = Class.forName(className);
        for (Human person : people) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName) && myClass.isInstance(person)) {
                return person;
            }
        }
        return null;
    }
    protected Human findPerson(String name, String className) throws ClassNotFoundException {
        String[] result = name.split(" ");
        return findPerson(result[0], result[1], className);
    }

    public Human findPerson(String name) throws ClassNotFoundException {
        return findPerson(name, "Model.Human");
    }

    public void whoYourChildren(String name) throws ClassNotFoundException {
        Human person = findPerson(name, "Model.Parent");
        if (person != null)
            ((Parent)person).whoYourChildren();
        else
            System.out.println("Not Fount children for " + name);
    }
    public void whoYourMother(String name) throws ClassNotFoundException {
        ((Child)findPerson(name, "Model.Child")).whoYourMother();
    }
    public void whoYourFather(String name) throws ClassNotFoundException {
        ((Child) findPerson(name, "Model.Child")).whoYourFather();
    }

    public void printAll() {
        for (Human man: people) {
            String role = man.getClass().toString().substring(12) + " role";
            System.out.println(man + " - " + role);
        }
    }
}
