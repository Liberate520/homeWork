import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Person> familyTree = new ArrayList<>();

    public void addPerson(Person person){
    familyTree.add(person);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Person person : familyTree){
            result.append(person).append("\n");
        }
        return result.toString();
    }
}
