import ru.gb.node.FamilyTree;
import ru.gb.person.Gender;
import ru.gb.person.Person;
import ru.gb.service.Service;
import ru.gb.writable.FileHandlerForTree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Service service = new Service();
        FileHandlerForTree fhTree = new FileHandlerForTree();

        service.createEmptyFamilyTree();
        service.addPerson(new Person("Frederick", Gender.Male, LocalDate.of(1905, 10, 11),
                LocalDate.of(1999, 6, 25)), 0);
        service.addPerson(new Person("Mary", Gender.Female, LocalDate.of(1912, 5, 10),
                LocalDate.of(2000, 8, 7)), 0);
        service.addPerson(new Person("Donald", Gender.Male, LocalDate.of(1946, 6, 14),
                service.getByName("Frederick", 0), service.getByName("Mary", 0)), 0);
        service.addPerson(new Person("Ivana", Gender.Female, LocalDate.of(1949, 2, 20),
                LocalDate.of(2022, 7, 14)), 0);
        service.addPerson(new Person("Donald Jr", Gender.Male, LocalDate.of(1977, 12, 31),
                service.getByName("Donald", 0), service.getByName("Ivana", 0)), 0);
        service.addPerson(new Person("Ivanka", Gender.Female, LocalDate.of(1981, 10, 30),
                service.getByName("Donald", 0), service.getByName("Ivana", 0)), 0);
        service.addPerson(new Person("Eric", Gender.Male, LocalDate.of(1984, 1, 6),
                service.getByName("Donald", 0), service.getByName("Ivana", 0)), 0);


        service.createEmptyFamilyTree();
        service.addPerson(new Person("Ivan", Gender.Male, LocalDate.of(1990, 10, 11)), 1);
        service.addPerson(new Person("Anastasia", Gender.Female, LocalDate.of(1985, 5, 10)), 1);
        service.addPerson(new Person("Maria", Gender.Female, LocalDate.of(2010, 6, 14),
                service.getByName("Ivan", 1), service.getByName("Anastasia", 1)), 1);



        System.out.println(service.getInfo());

        // Сохранение семейных древ
        service.saveTrees(fhTree);

//        Загрузка семейных древ
//        List<FamilyTree> loadedTree = service.loadTrees(fhTree);
//        for (FamilyTree tree : loadedTree) {
//            service.addFamilyTree(tree);
//        }
//        System.out.println(service.getInfo());

    }
}
