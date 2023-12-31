package ru.gb.dogs;

import ru.gb.dogs.Dog;
import ru.gb.node.FamilyTree;
import ru.gb.service.Service;
import ru.gb.treeItem.Gender;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class MainDogs {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Service<Dog> service = new Service<>();

//        service.createEmptyFamilyTree();
//        service.addItem(new Dog("Boo", Gender.Male, LocalDate.of(1905, 10, 11),
//                LocalDate.of(1999, 6, 25)), 0);
//        service.addItem(new Dog("Foo", Gender.Female, LocalDate.of(1912, 5, 10),
//                LocalDate.of(2000, 8, 7)), 0);
//
//        service.createEmptyFamilyTree();
//        service.addItem(new Dog("Poo", Gender.Male, LocalDate.of(1990, 10, 11)), 1);
//        service.addItem(new Dog("fu", Gender.Female, LocalDate.of(1985, 5, 10)), 1);
//        service.addItem(new Dog("Ichiro", Gender.Female, LocalDate.of(2010, 6, 14),
//                service.getByName("Poo", 1), service.getByName("fu", 1)), 1);
//
//
//
//        System.out.println(service.getInfo());
//
//        service.sortByAge();
//        System.out.println(service.getInfo());
//
//        service.sortByName();
//        System.out.println(service.getInfo());
//
//        // Сохранение семейных древ
//        service.saveTrees();

        // Загрузка семейных древ
        List<FamilyTree<Dog>> loadedTree = service.loadTrees();
        for (FamilyTree<Dog> tree : loadedTree) {
            service.addFamilyTree(tree);
        }
        System.out.println(service.getInfo());

    }
}
