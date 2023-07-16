
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FamilyTree {
    private HashMap<Person, HashMap<ConnectionType, HashSet<Person>>> family;

    public FamilyTree() {
        this.family = new HashMap<>();
    }

    public boolean addPerson(Person person) {
        if (!family.containsKey(person)) {
            HashMap<ConnectionType, HashSet<Person>> connections = new HashMap<>();
            family.put(person, connections);
            return true;
        }
        return false;
    }

    public boolean putConnection(Person connectFrom, ConnectionType key, Person connectTo) {
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

public String showConnections (Person person) {
        StringBuilder sb = new StringBuilder();
        sb.append(person);

        HashMap<ConnectionType, HashSet<Person>> connections = family.get(person);
        for (Map.Entry<ConnectionType, HashSet<Person>> item :
                connections.entrySet()) {
            sb.append(item.getKey()).append(": ");
            for (Person relative :
                    item.getValue()) {
                sb.append(relative.briefName()).append("; ");
            }
            sb.append("\n");
        }
    return sb.toString();
}

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
