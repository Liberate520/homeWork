
import fileWork.FilehandlerOS;
import fileWork.FilehandlerTXT;
import fileWork.Writeable;
import group.FamilyTree;
import group.Groupable;
import group.comparators.PersonComparatorById;
import person.Gender;
import person.Person;

public class Main {
        public static void main(String[] args) {
                Groupable familyTree= new FamilyTree();

                // familyTree.addPerson(new Person(1, "Авилова Клавдия", LocalDate.of(1922, 10, 14),
                //                 LocalDate.of(2009, 05, 10),
                //                 Gender.female, null, null, null));

                // familyTree.addPerson(new Person(2, "Мишина Надежда", LocalDate.of(1957, 3, 25),
                //                 null, Gender.female, familyTree.getPersonByName("Авилова Клавдия"), null,
                //                 null));

                // familyTree.addPerson(new Person(3, "Мишин Анатолий", LocalDate.of(1957, 8, 02),
                //                 null, Gender.male, null, null,
                //                 null));

                // familyTree.addPerson(new Person(4, "Мишина Олеся", LocalDate.of(1979, 9, 14),
                //                 null, Gender.female, familyTree.getPersonByName("Мишина Надежда"),
                //                 familyTree.getPersonByName("Мишин Анатолий"),
                //                 null));

                // familyTree.addPerson(new Person(5, "Мишина Дарья", LocalDate.of(1987, 04, 02),
                //                 null, Gender.female, familyTree.getPersonByName("Мишина Надежда"),
                //                 familyTree.getPersonByName("Мишин Анатолий"),
                //                 null));

                // familyTree.addPerson(new Person(6, "Вяткин Алексей", LocalDate.of(1975, 7, 1),
                //                 null, Gender.male, null, null,
                //                 null));

                // familyTree.addPerson(new Person(7, "Вяткин Константин", LocalDate.of(2010, 8,
                //                 11), null, Gender.male, familyTree.getPersonByName("Мишина Олеся"),
                //                 familyTree.getPersonByName("Вяткин Алексей"),
                //                 null));
                // familyTree.addPerson(new Person(158, "Вяткин Кирилл", LocalDate.of(2013, 7,
                //                 28),
                //                 null, Gender.male, familyTree.getPersonByName("Мишина Олеся"),
                //                 familyTree.getPersonByName("Вяткин Алексей"),
                //                 null));

                String filenameOS = "FamilyTree.dat";
                Writeable fileOS = new FilehandlerOS();

                // fileOS.SaveToFile(familyTree, filenameOS);
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
                System.out.println("Сортировка по полу:");
                familyTree.sortByGenderd();
                for (Person person : familyTree.getPersonList()) {
                        System.out.print(person);
                }
        }
}
