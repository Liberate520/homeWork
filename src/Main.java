import familyTree.ConnectionType;
import familyTree.FamilyTree;
import readWrite.FileHandler;

public class Main {
    public static void main(String[] args) {
        FamilyTree family = new FamilyTree();
        person.Person egor = new person.Person("Егор", "Меньшиков", "Леонидович",
                person.Gender.MALE, 1986);
        person.Person petr = new person.Person("Петр", "Меньшиков", "Леонидович",
                person.Gender.MALE, 1988);
        person.Person marina = new person.Person("Марина", "Меньшикова", "Рудольфовна",
                person.Gender.FEMALE, 1957, "Блохинцева");
        person.Person leonid = new person.Person("Леонид", "Меньшиков", "Иеронимович",
                person.Gender.MALE, 1954);

        System.out.println(family.addPerson(egor));
        family.addPerson(petr);
        family.addPerson(marina);
        family.addPerson(leonid);
        family.putConnection(egor, ConnectionType.PARENT, marina, true);
        family.putConnection(egor, ConnectionType.SIBLING, petr, true);
        family.putConnection(egor, ConnectionType.PARENT, leonid, true);
        family.putConnection(marina, ConnectionType.SPOUSE, leonid, true);
        family.putConnection(marina, ConnectionType.CHILD, petr, true);
        family.putConnection(leonid, ConnectionType.CHILD, petr, true);

        System.out.println(family.showConnections(leonid));
        System.out.println(family.showConnections(marina));
        System.out.println(family.showConnections(egor));
        System.out.println(family.showConnections(petr));

        FileHandler fh = new FileHandler();
        System.out.println(fh.write(family));

//        FileHandler fh = new FileHandler();
        FamilyTree familyRead = (FamilyTree) fh.read();
        System.out.println(familyRead);
    }
}

