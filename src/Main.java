import family_tree.FamilyTree;
import person.Gender;
import person.Person;
import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/family_tree/data/tree.out";
        FileHandler fileHandler = new FileHandler();

//        FamilyTree familyTree = TreeInitiate();
//        fileHandler.save(familyTree, filePath);

//        FamilyTree familyTree = (FamilyTree) fileHandler.read(filePath);
//        System.out.println(familyTree);

        ServiceTest();

    }
    static FamilyTree TreeInitiate(){
        FamilyTree familyTree = new FamilyTree();
        Person person1 = new Person("Ivan", "Ivanov", Gender.Male, LocalDate.of(1960, 1, 1));
        Person person2 = new Person("Maria", "Ivanova", Gender.Female, LocalDate.of(1960, 3, 21));
        Person person3 = new Person("Daria", "Ivanova", Gender.Female, LocalDate.of(1980, 9, 15), person1, person2);
        Person person4 = new Person("Maxim", "Ivanov", Gender.Male, LocalDate.of(1985, 5, 29), person1, person2);
        Person person5 = new Person("Petr", "Petrov", Gender.Male, LocalDate.of(1965, 2, 12));

        familyTree.add(person1);
        familyTree.add(person2);
        familyTree.add(person3);
        familyTree.add(person4);
        familyTree.add(person5);

        System.out.println(familyTree);
        System.out.println("____________________________");
        System.out.println(person1.getChildren());
        System.out.println(person3.getBirthDate());
        System.out.println(person3.getMother());
        System.out.println(person2.getMother());

        return familyTree;
    }

    static void ServiceTest(){
        Service service = new Service();
        service.addPerson("Ivan", "Ivanov", Gender.Male, LocalDate.of(1960, 1, 1));
        service.addPerson("Maria", "Ivanova", Gender.Female, LocalDate.of(1960, 3, 21));
        service.addPerson("Daria", "Ivanova", Gender.Female, LocalDate.of(1980, 9, 15));
        service.addPerson("Maxim", "Ivanov", Gender.Male, LocalDate.of(1985, 5, 29));
        service.addPerson("Petr", "Petrov", Gender.Male, LocalDate.of(1965, 2, 12));

        System.out.println(service.getInfo());
        service.sortByName();
        System.out.println("Отсортированное по имени " + service.getInfo());
        service.sortByAge();
        System.out.println("Отсортированное по возрасту " + service.getInfo());

    }
}
