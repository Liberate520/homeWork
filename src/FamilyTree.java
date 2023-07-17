
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Все семейные связи решил хранить тут, а не в полях класса Person.
 */
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

    /**
     * Метод ручного добавления связи
     * @param connectFrom от кого
     * @param key какая
     * @param connectTo к кому
     */
    public void putConnection(Person connectFrom, ConnectionType key, Person connectTo) {
        if (family.containsKey(connectFrom))
            if (family.get(connectFrom).containsKey(key))
                family.get(connectFrom).get(key).add(connectTo);
            else {
                HashSet<Person> person = new HashSet<>();
                person.add(connectTo);
                family.get(connectFrom).put(key, person);
            }
    }

    /**
     * То же самое что сверху, но автоматически добавляется соответствующая обратная связь
     * @param reverse если этот параметр true
     */
    public void putConnection(Person connectFrom, ConnectionType key, Person connectTo, boolean reverse) {
        putConnection(connectFrom, key, connectTo);
        if (reverse && !findConnection(connectTo, connectFrom)) {
            switch (key){
                case SIBLING -> putConnection(connectTo, ConnectionType.SIBLING, connectFrom);
                case SPOUSE -> putConnection(connectTo, ConnectionType.SPOUSE, connectFrom);
                case CHILD -> putConnection(connectTo, ConnectionType.PARENT, connectFrom);
                case PARENT -> putConnection(connectTo, ConnectionType.CHILD, connectFrom);
            }
        }
    }

    public boolean findConnection(Person connectFrom, Person connectTo) {
        HashMap<ConnectionType, HashSet<Person>> connections = family.get(connectFrom);
        for (Map.Entry<ConnectionType, HashSet<Person>> item :
                connections.entrySet()) {
            for (Person relative :
                    item.getValue()) {
                if (connectTo.equals(relative))
                    return true;
            }
        }
        return false;
    }

public String showConnections (Person person) {
        StringBuilder sb = new StringBuilder();
        sb.append(person).append("\n").append("Близкие родственники:\n");

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
