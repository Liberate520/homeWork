import familyTree.ConnectionType;
import familyTree.FamilyTree;
import readWrite.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree family = new FamilyTree();
        person.Person egor = new person.Person("Егор", "Меньшиков", "Леонидович",
                person.Gender.MALE, LocalDate.of(1986,3,13));
        person.Person petr = new person.Person("Петр", "Меньшиков", "Леонидович",
                person.Gender.MALE, LocalDate.of(1988,8,11));
        person.Person marina = new person.Person("Марина", "Меньшикова", "Рудольфовна",
                person.Gender.FEMALE, LocalDate.of(1957,11,30), "Блохинцева");
        person.Person leonid = new person.Person("Леонид", "Меньшиков", "Иеронимович",
                person.Gender.MALE, LocalDate.of(1954,10,18));

        System.out.println(family.addPerson(egor));
        family.addPerson(petr);
        family.addPerson(marina);
        family.addPerson(leonid);
        family.putConnection(egor, ConnectionType.PARENT, marina);
        family.putConnection(egor, ConnectionType.SIBLING, petr);
        family.putConnection(egor, ConnectionType.PARENT, leonid);
        family.putConnection(marina, ConnectionType.SPOUSE, leonid);
        family.putConnection(marina, ConnectionType.CHILD, petr);
        family.putConnection(leonid, ConnectionType.CHILD, petr);

        System.out.println(family.showConnections(leonid));
        System.out.println(family.showConnections(marina));
        System.out.println(family.showConnections(egor));
        System.out.println(family.showConnections(petr));

        FileHandler fh = new FileHandler();
        System.out.println(fh.write(family) ? "Write OK" : "Failed to write");

        FamilyTree familyRead = (FamilyTree) fh.read();
        System.out.println(familyRead);
    }
}

