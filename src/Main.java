import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FamilyTree family = new FamilyTree();
        Person egor = new Person("Егор", "Меньшиков", "Леонидович",
                Gender.MALE, 1986);
        Person petr = new Person("Петр", "Меньшиков", "Леонидович",
                Gender.MALE, 1988);
        Person marina = new Person("Марина", "Меньшикова", "Рудольфовна",
                Gender.FEMALE, 1957, "Блохинцева");
        Person leonid = new Person("Леонид", "Меньшиков", "Иеронимович",
                Gender.MALE, 1954);
        System.out.println(family.addPerson(egor));
        family.addPerson(petr);
        family.addPerson(marina);
        family.addPerson(leonid);
        family.putConnection(egor, ConnectionType.SIBLING, petr);
        family.putConnection(egor, ConnectionType.PARENT, leonid);
        family.putConnection(egor, ConnectionType.PARENT, marina);
        System.out.println(family.showConnections(egor));

//        HashMap<Person, HashMap<ConnectionType, HashSet<Person>>> ppl = new HashMap<>();
//        HashMap<ConnectionType, HashSet<Person>> subMap = new HashMap<>();
//        HashSet<Person> subSet = new HashSet<>();
//        HashSet<Person> subSet2 = new HashSet<>();
//        subSet.add(petr);
//        subSet2.add(marina);
//        subSet2.add(leonid);
//        for (Person person :
//                subSet) {
//            System.out.println(person.briefName());
//        }
//        subMap.put(ConnectionType.SIBLING, subSet);
//        subMap.put(ConnectionType.PARENT, subSet2);
//        ppl.put(egor, subMap);
//        System.out.println(egor);
//        HashMap<ConnectionType, HashSet<Person>> hm = ppl.get(egor);
//        for (Map.Entry<ConnectionType, HashSet<Person>> item :
//                hm.entrySet()) {
//            System.out.print(item.getKey() + ": ");
//            for (Person person :
//                    item.getValue()) {
//                System.out.print(person.briefName() + "; ");
//            }
//            System.out.println();
//        }
    }

}

