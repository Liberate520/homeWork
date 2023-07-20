import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person human = new Person("Алексей", "Шишкарев",
                "Юрьевич", LocalDate.of(1987, 7, 12),
                Gender.Male);
        Person human2 = new Person("Лариса", "Шишкарева",
                "Александровна", LocalDate.of(1954, 8, 2),
                Gender.Female);
        Person human3 = new Person("Юрий", "Шишкарев",
                "Константинович", LocalDate.of(1953, 11, 15),
                Gender.Male);
        Person human4 = new Person("Виталий", "Шишкарев",
                "Юрьевич", LocalDate.of(1981, 9,17),
                Gender.Male);

        human.setMather(human2);
        human4.setMather(human2);
        human.setFather(human3);
        human4.setFather(human3);


        familyTree.addHumanList(human);
        familyTree.addHumanList(human2);
        familyTree.addHumanList(human3);
        familyTree.addHumanList(human4);

        System.out.println(human3);

        System.out.println(familyTree.findPerson("Виталий"));

        System.out.println(familyTree.getHumanListInfo());
        System.out.println(human2.getChildren());


    }
}