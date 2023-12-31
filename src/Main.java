import ru.gb.node.FamilyTree;
import ru.gb.treeItem.Gender;
import ru.gb.person.Person;
import ru.gb.service.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Service<Person> service = new Service<>();

        service.createEmptyFamilyTree();
        service.addItem(new Person("Frederick", Gender.Male, LocalDate.of(1905, 10, 11),
                LocalDate.of(1999, 6, 25)), 0);
        service.addItem(new Person("Mary", Gender.Female, LocalDate.of(1912, 5, 10),
                LocalDate.of(2000, 8, 7)), 0);
        service.addItem(new Person("Donald", Gender.Male, LocalDate.of(1946, 6, 14),
                service.getByName("Frederick", 0), service.getByName("Mary", 0)), 0);
        service.addItem(new Person("Ivana", Gender.Female, LocalDate.of(1949, 2, 20),
                LocalDate.of(2022, 7, 14)), 0);
        service.addItem(new Person("Donald Jr", Gender.Male, LocalDate.of(1977, 12, 31),
                service.getByName("Donald", 0), service.getByName("Ivana", 0)), 0);
        service.addItem(new Person("Ivanka", Gender.Female, LocalDate.of(1981, 10, 30),
                service.getByName("Donald", 0), service.getByName("Ivana", 0)), 0);
        service.addItem(new Person("Eric", Gender.Male, LocalDate.of(1984, 1, 6),
                service.getByName("Donald", 0), service.getByName("Ivana", 0)), 0);


        service.createEmptyFamilyTree();
        service.addItem(new Person("Ivan", Gender.Male, LocalDate.of(1990, 10, 11)), 1);
        service.addItem(new Person("Anastasia", Gender.Female, LocalDate.of(1985, 5, 10)), 1);
        service.addItem(new Person("Maria", Gender.Female, LocalDate.of(2010, 6, 14),
                service.getByName("Ivan", 1), service.getByName("Anastasia", 1)), 1);



        System.out.println(service.getInfo());

        service.sortByAge();
        System.out.println(service.getInfo());

        service.sortByName();
        System.out.println(service.getInfo());

        // Сохранение семейных древ
        service.saveTrees();

//        // Загрузка семейных древ
//        List<FamilyTree<Person>> loadedTree = service.loadTrees();
//        for (FamilyTree<Person> tree : loadedTree) {
//            service.addFamilyTree(tree);
//        }
//        System.out.println(service.getInfo());

    }
}
