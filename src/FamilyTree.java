
import java.util.HashMap;

/**
 * Все семейные связи решил хранить тут, а не в полях класса Person.
 */
public class FamilyTree {
    private HashMap<Person, Connections> family;

    public FamilyTree() {
        this.family = new HashMap<>();
    }

    public boolean addPerson(Person person) {
        if (!family.containsKey(person)) {
            Connections connections = new Connections();
            family.put(person, connections);
            return true;
        }
        return false;
    }

    public void putConnection(Person connectFrom, ConnectionType key, Person connectTo) {
        if (family.containsKey(connectFrom))
            family.get(connectFrom).putConnections(key, connectTo);
    }

    /**
     * То же самое что сверху, но автоматически добавляется соответствующая обратная связь
     *
     * @param reverse если этот параметр true
     */
    public void putConnection(Person connectFrom, ConnectionType key, Person connectTo, boolean reverse) {
        putConnection(connectFrom, key, connectTo);
        if (reverse && !findConnection(connectTo, connectFrom)) {
            switch (key) {
                case SIBLING -> putConnection(connectTo, ConnectionType.SIBLING, connectFrom);
                case SPOUSE -> putConnection(connectTo, ConnectionType.SPOUSE, connectFrom);
                case CHILD -> putConnection(connectTo, ConnectionType.PARENT, connectFrom);
                case PARENT -> putConnection(connectTo, ConnectionType.CHILD, connectFrom);
            }
        }
    }

    public boolean findConnection(Person connectFrom, Person connectTo) {
        Connections connections = family.get(connectFrom);
        return connections.find(connectTo);
    }

    public String showConnections(Person person) {
        return person + "\n" + "Близкие родственники:\n" +
                family.get(person);
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
