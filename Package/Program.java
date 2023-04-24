package Package;
import Package.WorkWithFiles.Files;
import Package.Tree.Person;
import Package.Tree.Tree;

import java.io.*;
import java.time.LocalDate;


public class Program implements Serializable {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Tree family = new Tree();
        family.addMember(new Person(1, "Иван", "Иванов", LocalDate.of(1948, 1, 22), null));
        family.addMember(new Person(2, "Галина", "Иванова", LocalDate.of(1950, 5, 12), null));
        family.addMember(new Person(3, "Артём", "Иванов", LocalDate.of(1973, 2, 25), null, family.setById(1), family.setById(2)));
        family.addMember(new Person(4, "Иван", "Иванов", LocalDate.of(1974, 3, 10), null, family.setById(1), family.setById(2)));
        family.addMember(new Person(5, "Анна", "Иванова", LocalDate.of(1993, 1, 30), null, family.setById(3), null));
        family.addMember(new Person(6, "Анастасия", "Иванова", LocalDate.of(1995, 1, 21), null, family.setById(3), null));
        family.addMember(new Person(7, "Василий", "Иванов", LocalDate.of(1995, 9, 28), null, family.setById(4), null));
        family.addMember(new Person(8, "Петр", "Иванов", LocalDate.of(1996, 10, 19), null, family.setById(4), null));
        family.addMember(new Person(9, "Валентина", "Иванова", LocalDate.of(1997, 8, 14), null, family.setById(4), null));

        family.iterateByName();
        System.out.println(family.showFamily());
    }
}
