import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Person person1 = new Person("Ivan", "Ivanov", Gender.Male, LocalDate.of(1960, 1, 1));
        Person person2 = new Person("Maria", "Ivanova", Gender.Female, LocalDate.of(1960, 3, 21));
        Person person3 = new Person("Daria", "Ivanova", Gender.Female, LocalDate.of(1980, 9, 15), person1, person2);
        Person person4 = new Person("Maxim", "Ivanov", Gender.Male, LocalDate.of(1985, 5, 29), person1, person2);
        Person person5 = new Person("Petr", "Petrov", Gender.Male, LocalDate.of(1965, 2, 12));

        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);
        familyTree.addPerson(person5);


        System.out.println(familyTree);

        System.out.println(person1.getChildren());
        System.out.println(person3.getBirthDate());
        System.out.println(person3.getMother());
        System.out.println(person2.getMother());
    }
}
