
import java.util.HashMap;
import java.util.HashSet;

public class FamilyTree {
    private HashMap<Person, HashMap<String, HashSet<Person>>> family;

    public FamilyTree() {
        this.family = new HashMap<>();
    }

    public boolean addPerson(Person person) {
        if (!family.containsKey(person)) {
            HashMap<String, HashSet<Person>> connections = new HashMap<>();
            family.put(person, connections);
            return true;
        }
        return false;
    }

    public boolean putConnection(Person connectFrom, String key, Person connectTo) {
        if (family.containsKey(connectFrom))
            if (family.get(connectFrom).containsKey(key))
                return family.get(connectFrom).get(key).add(connectTo);
            else {
                HashSet<Person> person = new HashSet<>();
                family.get(connectFrom).put(key, person);
                return true;
            }
        return false;
    }

//    public String

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person :
                family.keySet()) {
            sb.append(person).append("\n");
        }
        return sb.toString();
    }
}
