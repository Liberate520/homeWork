import java.io.Serializable;
import java.io.*;
import java.time.LocalDate;
public class Main implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTolstoy = new FamilyTree();
        
        Person person1 = new Person(1, "Куницин Алексей", LocalDate.of(1912, 11, 12), LocalDate.of(2006, 03, 11),
                Gender.Male, null, null, null);

        Person person2 = new Person(2, "Евгапова Надежда", LocalDate.of(1962, 1, 15), null, Gender.Female, person1, null, null);

        Person person3 = new Person(3, "Евгапова Нина", LocalDate.of(1947, 5, 01), null, Gender.Male, null, null, null);

        Person person4 = new Person(4, "Евгапова Олеся", LocalDate.of(1974, 1, 25), null, Gender.Female, person2, person3, null);

        Person person5 = new Person(5, "Евгапова Анастасия", LocalDate.of(1980, 05, 02), null, Gender.Female, person2, person3, null);

        Person person6 = new Person(6, "Куликов Константин", LocalDate.of(2007, 8, 10), null, Gender.Male, person4, null, null);

        Person person7 = new Person(7, "Куликов Иван", LocalDate.of(2011, 4, 20), null, Gender.Male, person4, null, null);
        System.out.println(familyTolstoy.toString());
    }

}