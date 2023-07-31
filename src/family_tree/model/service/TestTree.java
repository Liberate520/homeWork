package family_tree.model.service;

import family_tree.model.family_tree.*;
import family_tree.model.human.*;

import java.time.LocalDate;

public class TestTree {
    static FamilyTree<Human> firstTree() {
        FamilyTree<Human> tree = new FamilyTree<Human>();

        tree.add(new Human (21, "Анна", Gender.Female, 
        LocalDate.of(1981, 1, 11),
        tree.getByName("Нина"), tree.getByName("Иван")));

        tree.add(new Human (22, "Борис", Gender.Male, 
        LocalDate.of(1980, 2, 15), tree.getByName("Анна")));

        tree.add(new Human (31, "Арина", Gender.Female, 
        LocalDate.of(2010, 3, 30),
        tree.getByName("Анна"), tree.getByName("Борис")));

        tree.add(new Human (32, "Глеб", Gender.Male, 
        LocalDate.of(2015, 4, 21),
        tree.getByName("Анна"), tree.getByName("Борис")));

        tree.add(new Human (23, "Нина", Gender.Female, 
        LocalDate.of(1975, 5, 7), tree.getByName("Иван")));

        tree.add(new Human (24, "Иван", Gender.Male, 
        LocalDate.of(1970, 6, 28), tree.getByName("Нина")));

        tree.add(new Human (33, "Ирина", Gender.Female, 
        LocalDate.of(2000, 1, 1),
        tree.getByName("Нина"), tree.getByName("Иван")));

        tree.add(new Human(34, "Михаил", Gender.Male, LocalDate.of(2022, 05, 10), 
        tree.getByName("Анна"), tree.getByName("Борис")));


        Human grandMother = new Human(11, "Клавдия", Gender.Female, LocalDate.of(1950, 8, 15));
        grandMother.addChild(tree.getByName("Нина"));
        grandMother.addChild(tree.getByName("Анна"));
        // grandMother.addSpouse(tree.getByName("Семен"));
        tree.add(grandMother);

        Human grandFather = new Human(12, "Семен", Gender.Male, LocalDate.of(1947, 8, 19), 
        tree.getByName("Клавдия"));
        grandFather.addChild(tree.getByName("Нина"));
        grandFather.addChild(tree.getByName("Анна"));
        tree.add(grandFather);
  
        return tree;
        }
}
