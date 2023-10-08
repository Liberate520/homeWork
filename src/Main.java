import family_tree.FamilyTree;
import person.Gender;
import person.Person;
import person.PersonService;
import serialization.FileHandler;


import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {

        FamilyTree<Person> familyTree = getCustomFamilyTree();

        // FamilyTree теперь итерируемый, ура
        for (Person person: familyTree) {
            System.out.println(person);
        }

//        System.out.println("_______________");
//
//        familyTree.sortByName();
//
//        System.out.println(familyTree);
//
//        System.out.println("_______________");
//
//        familyTree.sortByBirthDate();
//
//        System.out.println(familyTree);

    }

    static FamilyTree<Person> getCustomFamilyTree() {
        FamilyTree<Person> familyTree = new FamilyTree<>("Романовы");
        PersonService service = new PersonService();

        Person mihail = new Person("Михаил Федорович",
                LocalDate.of(1596, Month.JULY, 22),
                LocalDate.of(1596, Month.JULY, 22),
                Gender.Male);

        Person evdakia = new Person("Евдакия Лукьянина",
                LocalDate.of(1608, 1, 1),
                LocalDate.of(1645, Month.AUGUST, 18),
                Gender.Female);

        service.isHusbands(mihail, evdakia);

        Person alexey = new Person("Алексей Михайлович",
                LocalDate.of(1629, Month.MARCH, 19),
                LocalDate.of(1676, Month.FEBRUARY, 8),
                Gender.Male);

        service.isChildren(alexey, mihail, evdakia);

        Person maria = new Person("Мария Ильинична",
                LocalDate.of(1624, Month.APRIL, 11),
                LocalDate.of(1669, Month.MARCH, 13),
                Gender.Female);

        Person natalya = new Person("Наталья Кирилловна",
                LocalDate.of(1651, Month.SEPTEMBER, 1),
                LocalDate.of(1694, Month.FEBRUARY, 4),
                Gender.Female);

        service.isHusbands(alexey, maria);
        service.isHusbands(alexey, natalya);

        Person petr1 = new Person("Петр I Алексеевич",
                LocalDate.of(1672, Month.JUNE, 9),
                LocalDate.of(1725, Month.FEBRUARY, 8),
                Gender.Male);

        service.isChildren(petr1, alexey, natalya);

        Person ivan5 = new Person("Иоанн V Алексеевич",
                LocalDate.of(1666, Month.SEPTEMBER, 6),
                LocalDate.of(1696, Month.FEBRUARY, 8),
                Gender.Male);

        service.isChildren(ivan5, alexey, maria);

        // System.out.println(familyTree.getPersonInfo(alexey));

        familyTree.addInFamily(mihail);
        familyTree.addInFamily(evdakia);
        familyTree.addInFamily(alexey);
        familyTree.addInFamily(maria);
        familyTree.addInFamily(natalya);
        familyTree.addInFamily(petr1);
        familyTree.addInFamily(ivan5);

        return familyTree;
    }

    static void serializationFamilyTree(FamilyTree<Person> familyTree) {
        FileHandler fileHandler = new FileHandler();
        String serializationFile = "src/serialization/saveFile.txt";
        fileHandler.writeObject(familyTree, serializationFile);
    }

    static FamilyTree<Person> deserializationFamilyTree() {
        FileHandler fileHandler = new FileHandler();
        String serializationFile = "src/serialization/saveFile.txt";
        return (FamilyTree) fileHandler.readObject(serializationFile);
    }
}
