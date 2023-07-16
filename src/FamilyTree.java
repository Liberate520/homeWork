
import java.util.ArrayList;
import java.util.HashMap;

public class FamilyTree {
    private HashMap<Person, HashMap<String, ArrayList<Person>>> family;

    public FamilyTree() {
    }

    public boolean addPerson(Person person) {
        HashMap<String, ArrayList<Person>> links = new HashMap<>();
        if (!family.containsKey(person)) {
            family.put(person, links);
            return true;
        }
        return false;
    }
}
