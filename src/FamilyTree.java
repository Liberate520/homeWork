import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> persons;

    public FamilyTree (){
        this.persons = new ArrayList<>();
    }

    public void pushToTree (Person person) {
        this.persons.add(person);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Person person: persons) {
            output.append(person.getFirstName() + " " + person.getLastName() + "\n");
        }
        return output.toString();
    }
}
