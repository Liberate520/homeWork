import java.time.*;
import FileWork.FilehandlerOS;
import FileWork.FilehandlerTXT;
import FileWork.Writeable;
import Group.FamilyTree;
import Group.Groupable;
import Group.Comparators.PersonComparatorById;
import Person.Gender;
import Person.Person;

public class Main {
        public static void main(String[] args) {
                Groupable<Person> familyTree= new FamilyTree<>();

                familyTree.addPerson(new Person(1, "Сергеева Светлана", LocalDate.of(1934, 5, 21),
                                LocalDate.of(2004, 7, 17),
                                Gender.female, null, null, null));

                familyTree.addPerson(new Person(2, "Иванова Анастасия", LocalDate.of(1959, 9, 14),
                                null, Gender.female, familyTree.getPersonByName("Сергеева Светлана"), null,
                                null));

                familyTree.addPerson(new Person(3, "Иванов Петр", LocalDate.of(1956, 4, 11),
                                null, Gender.male, null, null,
                                null));

                familyTree.addPerson(new Person(4, "Иванова Александра", LocalDate.of(1982, 3, 22),
                                null, Gender.female, familyTree.getPersonByName("Иванова Анастасия"),
                                familyTree.getPersonByName("Иванов Петр"),
                                null));

                familyTree.addPerson(new Person(5, "Иванов Иван", LocalDate.of(1986, 11, 16),
                                null, Gender.male, familyTree.getPersonByName("Иванова Анастасия"),
                                familyTree.getPersonByName("Иванов Петр"),
                                null));

                familyTree.addPerson(new Person(6, "Петров Владимир", LocalDate.of(1979, 6, 12),
                                null, Gender.male, null, null,
                                null));

                familyTree.addPerson(new Person(7, "Петров Игорь", LocalDate.of(2005, 8,
                                12), null, Gender.male, familyTree.getPersonByName("Иванова Александра"),
                                familyTree.getPersonByName("Петров Владимир"),
                                null));
                familyTree.addPerson(new Person(8, "Петрова Людмила", LocalDate.of(2009, 12, 19),
                                null, Gender.female, familyTree.getPersonByName("Иванова Александра"),
                                familyTree.getPersonByName("Петров Владимир"),
                                null));

                String filenameOS = "FamilyTree.dat";
                String filenameTXT = "FamilyTree.txt";
                 
                Writeable<Person> fileOS = new FilehandlerOS<>();
                Writeable<Person> fileTXT = new FilehandlerTXT<>();


                fileOS.saveToFile(familyTree, filenameOS);
                fileTXT.saveToFile(familyTree, filenameTXT);
                familyTree= fileOS.LoadFromFile(filenameOS);

                for (Person person : familyTree.getPersonList()) {
                System.out.print(person);
                }

                System.out.println("\n");
                System.out.println("Сортировка по имени:");
                familyTree.sortByName();
                for (Person person : familyTree.getPersonList()) {
                        System.out.print(person);
                }

                System.out.println("\n");
                System.out.println("Сортировка по возрасту:");
                familyTree.sortByAge();
                for (Person person : familyTree.getPersonList()) {
                        System.out.print(person);
                }

                System.out.println("\n");
                System.out.println("Сортировка по детям:");
                familyTree.sortByChildren();
                for (Person person : familyTree.getPersonList()) {
                        System.out.print(person);
                }
              

                System.out.println("\n");
                System.out.println("Сортировка по полу:");
                familyTree.sortByGenderd();
                for (Person person : familyTree.getPersonList()) {
                        System.out.print(person);
                }

                
        }
}
