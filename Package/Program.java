package Package;
import Package.Model.Tree.Service;
import Package.Model.Tree.Person;
import Package.Model.Tree.Tree;
import Package.View.Console;
import Package.View.View;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;


public class Program implements Serializable {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {

        Tree<Person> family = new Tree<>();
        Service<Tree> familyTree = new Service(family);
        familyTree.addMember("Иван", "Иванов", LocalDate.of(1948, 1, 22), null, null, null);
        familyTree.addMember("Галина", "Иванова", LocalDate.of(1950, 5, 12), null, null, null);
        familyTree.addMember("Артём", "Иванов", LocalDate.of(1973, 2, 25), null, family.setById(1), family.setById(2));
        familyTree.addMember("Иван", "Иванов", LocalDate.of(1974, 3, 10), null, family.setById(1), family.setById(2));
        familyTree.addMember("Анна", "Иванова", LocalDate.of(1993, 1, 30), null, family.setById(3), null);
        familyTree.addMember("Анастасия", "Иванова", LocalDate.of(1995, 1, 21), null, family.setById(3), null);
        familyTree.addMember("Василий", "Иванов", LocalDate.of(1995, 9, 28), null, family.setById(4), null);
        familyTree.addMember("Петр", "Иванов", LocalDate.of(1996, 10, 19), null, family.setById(4), null);
        familyTree.addMember("Валентина", "Иванова", LocalDate.of(1997, 8, 14), null, family.setById(4), null);

        View view = new Console();
        view.start();
    }
}
