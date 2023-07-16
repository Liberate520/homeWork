import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        FamilyTree family = new FamilyTree();
        Person egor = new Person("Егор", "Меньшиков", "Леонидович",
                Gender.MALE, 1986, null, 2100);
        Person petr = new Person("Петр", "Меньшиков", "Леонидович",
                Gender.MALE, 1988);
        Person marina = new Person("Марина", "Меньшикова", "Рудольфовна",
                Gender.FEMALE,1957,"Блохинцева");
        System.out.println(family.addPerson(egor));
        System.out.println(family.addPerson(egor));
        family.addPerson(petr);
        family.addPerson(marina);
        System.out.println(family.putConnection(egor, "брат", petr));
    }
}
