import model.familyTree.ConnectionType;
import model.familyTree.Connections;
import model.familyTree.FamilyTree;
import model.person.Person;

import java.time.LocalDate;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> family = makeTree();

        TreeMap<Person, Connections<Person>> sortAge = family.sortByAge();
        System.out.println(sortAge);

        System.out.println("+++++++++++++++++");

        TreeMap<Person, Connections<Person>> sortName = family.sortByName();
        System.out.println(sortName);
    }

    public static FamilyTree<Person> makeTree() {
        FamilyTree<Person> result = new FamilyTree<>();
        model.person.Person egor = new model.person.Person("Егор", "Меньшиков", "Леонидович",
                model.person.Gender.MALE, LocalDate.of(1986, 3, 13));
        model.person.Person petr = new model.person.Person("Петр", "Меньшиков", "Леонидович",
                model.person.Gender.MALE, LocalDate.of(1988, 8, 11));
        model.person.Person marina = new model.person.Person("Марина", "Меньшикова", "Рудольфовна",
                model.person.Gender.FEMALE, LocalDate.of(1957, 11, 30), "Блохинцева");
        model.person.Person leonid = new model.person.Person("Леонид", "Меньшиков", "Иеронимович",
                model.person.Gender.MALE, LocalDate.of(1954, 10, 18));

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

