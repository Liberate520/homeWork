import familyTree.ConnectionType;
import familyTree.Connections;
import familyTree.FamilyTree;
import person.Person;

import java.time.LocalDate;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        FamilyTree family = makeTree();

        TreeMap<Person, Connections> sortAge = family.sortByAge();
        System.out.println(sortAge);

        System.out.println("+++++++++++++++++");

        TreeMap<Person, Connections> sortName = family.sortByName();
        System.out.println(sortName);
    }

    public static FamilyTree makeTree() {
        FamilyTree result = new FamilyTree();
        person.Person egor = new person.Person("Егор", "Меньшиков", "Леонидович",
                person.Gender.MALE, LocalDate.of(1986, 3, 13));
        person.Person petr = new person.Person("Петр", "Меньшиков", "Леонидович",
                person.Gender.MALE, LocalDate.of(1988, 8, 11));
        person.Person marina = new person.Person("Марина", "Меньшикова", "Рудольфовна",
                person.Gender.FEMALE, LocalDate.of(1957, 11, 30), "Блохинцева");
        person.Person leonid = new person.Person("Леонид", "Меньшиков", "Иеронимович",
                person.Gender.MALE, LocalDate.of(1954, 10, 18));

        result.addPerson(egor);
        result.addPerson(petr);
        result.addPerson(marina);
        result.addPerson(leonid);
        result.putConnection(egor, ConnectionType.PARENT, marina);
        result.putConnection(egor, ConnectionType.SIBLING, petr);
        result.putConnection(egor, ConnectionType.PARENT, leonid);
        result.putConnection(marina, ConnectionType.SPOUSE, leonid);
        result.putConnection(marina, ConnectionType.CHILD, petr);
        result.putConnection(leonid, ConnectionType.CHILD, petr);
        return result;
    }
}

