import geotree.GeoTree;
import geotree.GeoTreeIO;
import person.Gender;
import person.Person;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Person irina = new Person("Ирина", new GregorianCalendar(1985, Calendar.JANUARY, 13), Gender.Female);
        Person igor = new Person("Игорь", new GregorianCalendar(1984, Calendar.OCTOBER, 25),Gender.Male);
        Person vasya = new Person("Вася", new GregorianCalendar(2001, Calendar.MARCH, 17),Gender.Male, irina, igor);
        Person masha = new Person("Маша", new GregorianCalendar(1997, Calendar.MAY, 20),Gender.Female, irina, igor);
        GeoTree gt = new GeoTree();
        gt.appendPerson(irina);
        gt.appendPerson(masha);
        gt.appendPerson(igor);
        gt.appendPerson(vasya);
        gt.autoAppendChildren();

        System.out.println("Дети Ирины");
        System.out.println(new Research(gt).spend(irina, "child"));

        System.out.println("Родители Маши");
        System.out.println(new Research(gt).spend(masha, "mother"));
        System.out.println(new Research(gt).spend(masha, "father"));

        System.out.println("Дети Игоря");
        System.out.println(new Research(gt).spend(igor, "child"));

        System.out.println("Исходный список:");
        for (Person person: gt.getTree()) {
            System.out.println(person);
        }
        System.out.println("Список, отсортированный по возрасту:");
        gt.sortByAge();
        for (Person person: gt.getTree()) {
            System.out.println(person);
        }
        System.out.println("Список, отсортированный по имени:");
        gt.sortByName();
        for (Person person: gt.getTree()) {
            System.out.println(person);
        }

        System.out.println();
        System.out.println(new Research(gt).searchAge());
        GeoTreeIO io = new GeoTreeIO();
        gt.save(io);
        gt.restore(io);
    }
}