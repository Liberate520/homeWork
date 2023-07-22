import readWrite.FileHandler;

public class Main {
    public static void main(String[] args) {
//        FamilyTree family = new FamilyTree();
//        Person egor = new Person("Егор", "Меньшиков", "Леонидович",
//                Gender.MALE, 1986);
//        Person petr = new Person("Петр", "Меньшиков", "Леонидович",
//                Gender.MALE, 1988);
//        Person marina = new Person("Марина", "Меньшикова", "Рудольфовна",
//                Gender.FEMALE, 1957, "Блохинцева");
//        Person leonid = new Person("Леонид", "Меньшиков", "Иеронимович",
//                Gender.MALE, 1954);
//
//        System.out.println(family.addPerson(egor));
//        family.addPerson(petr);
//        family.addPerson(marina);
//        family.addPerson(leonid);
//        family.putConnection(egor, ConnectionType.PARENT, marina, true);
//        family.putConnection(egor, ConnectionType.SIBLING, petr, true);
//        family.putConnection(egor, ConnectionType.PARENT, leonid, true);
//        family.putConnection(marina, ConnectionType.SPOUSE, leonid, true);
//        family.putConnection(marina, ConnectionType.CHILD, petr, true);
//        family.putConnection(leonid, ConnectionType.CHILD, petr, true);
//
//        System.out.println(family.showConnections(leonid));
//        System.out.println(family.showConnections(marina));
//        System.out.println(family.showConnections(egor));
//        System.out.println(family.showConnections(petr));

        FileHandler fh = new FileHandler();
        FamilyTree family = (FamilyTree) fh.read();
        System.out.println(family);

    }
}

