import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tree Tree = new Tree();
        Person person1 = new Person(1, "Куницин Алексей", LocalDate.of(1912, 11, 12), LocalDate.of(2006, 03, 11),
                Gender.male, null, null, null);
        Tree.addPerson(person1);

        Person person2 = new Person(2, "Евгапова Надежда", LocalDate.of(1962, 1, 15), null, Gender.female, person1, null, null);
        Tree.addPerson(person2);

        Person person3 = new Person(3, "Евгапова Нина", LocalDate.of(1947, 5, 01), null, Gender.male, null, null, null);
        Tree.addPerson(person3);

        Person person4 = new Person(4, "Евгапова Олеся", LocalDate.of(1974, 1, 25), null, Gender.female, person2, person3, null);
        Tree.addPerson(person4);

        Person person5 = new Person(5, "Евгапова Анастасия", LocalDate.of(1980, 05, 02), null, Gender.female, person2, person3, null);
        Tree.addPerson(person5);

        Person person6 = new Person(6, "Куликов Константин", LocalDate.of(2007, 8, 10), null, Gender.male, person4, null, null);
        Tree.addPerson(person6);

        Person person7 = new Person(7, "Куликов Иван", LocalDate.of(2011, 4, 20), null, Gender.male, person4, null, null);
        Tree.addPerson(person7);

        System.out.println(Tree.toString());
    }

}