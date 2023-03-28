import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Person person1 = new Person(1, "Авилова Клавдия", LocalDate.of(1922, 10, 14), LocalDate.of(2009, 05, 10),
                Gender.female, null, null, null);
        familyTree.addPerson(person1);

        Person person2 = new Person(2, "Мишина Надежда", LocalDate.of(1957, 3, 25), null, Gender.female, person1, null,
                null);
        familyTree.addPerson(person2);

        Person person3 = new Person(3, "Мишина Анатолий", LocalDate.of(1957, 8, 02), null, Gender.male, null, null,
                null);
        familyTree.addPerson(person3);

        Person person4 = new Person(4, "Мишина Олеся", LocalDate.of(1979, 9, 14), null, Gender.female, person2, person3,
                null);
        familyTree.addPerson(person4);

        Person person5 = new Person(5, "Мишина Дарья", LocalDate.of(1987, 04, 02), null, Gender.female, person2,
                person3,
                null);
        familyTree.addPerson(person5);

        Person person6 = new Person(6, "Вяткин Константин", LocalDate.of(2010, 8, 11), null, Gender.male, person4, null,
                null);
        familyTree.addPerson(person6);

        Person person7 = new Person(7, "Вяткин Кирилл", LocalDate.of(2013, 7, 28), null, Gender.male, person4, null,
                null);
        familyTree.addPerson(person7);

        System.out.println(familyTree.toString());
        familyTree.findPerson();
    }

}
