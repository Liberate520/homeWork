package family_tree;

import java.time.LocalDate;
import java.io.*;
import java.util.List;

import family_tree.family_tree.*;
import family_tree.human.*;
import family_tree.writer.*;

public class Main {
    public static void main (String [] args) {
        String filePath = "family_tree/tree.out";
        
        FileHandler fileHandler = new FileHandler();

        FamilyTree<Human> tree = new FamilyTree<>();
        
        System.out.println(tree);

        tree.sortByName();
        System.out.println("Сортировка по имени:");
        System.out.println(tree);

        tree.sortByBirthDate();
        System.out.println("Сортировка по дате рождения:");
        System.out.println(tree);
        
        fileHandler.save(tree, filePath);

        // FileHandler fileHandler = new FileHandler();
        // FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        // System.out.println(tree);
    }

    static FamilyTree<Human> firstTree() {
        FamilyTree<> tree = new FamilyTree<>();
        // static FamilyTree<E> firstTree() {
        //     FamilyTree<E> tree = new FamilyTree<E>();

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

        Human grandFother = new Human(12, "Семен", Gender.Male, LocalDate.of(1947, 8, 19), 
        tree.getByName("Клавдия"));
        grandFother.addChild(tree.getByName("Нина"));
        grandFother.addChild(tree.getByName("Анна"));
        tree.add(grandFother);
  
        return tree;
        }
    
    // public static void main(String[] args) {    
    // for (int i = 0; i < wifes.length; i++) {
    //         System.out.println(Human.wifes[i]);
    //     }
    // }
    
}



// package family_tree;

// import java.time.LocalDate;
// // import java.io.*;
// // import java.util.List;

// import family_tree.family_tree.*;
// import family_tree.human.*;
// import family_tree.writer.*;

// public class Main {
//     public static void main (String [] args) {
//         String filePath = "family_tree/tree.out";

//         FileHandler fileHandler = new FileHandler();

//         FamilyTree tree = firstTree();
//         // System.out.println(tree.getInfo());
//         System.out.println(tree);

//         tree.sortByName();
//         System.out.println("Сортировка по имени:");
//         System.out.println(tree);

//         tree.sortByBirthDate();
//         System.out.println("Сортировка по дате рождения:");
//         System.out.println(tree);

//         fileHandler.save(tree, filePath);

//         // FileHandler fileHandler = new FileHandler();
//         // FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
//         // System.out.println(tree);
//     }

//     static FamilyTree firstTree() {
//         FamilyTree tree = new FamilyTree();

//         tree.add(new Human ("Анна", Gender.Female, 
//         LocalDate.of(1981, 1, 11),
//         tree.getByName("Нина"), tree.getByName("Иван")));

//         tree.add(new Human ("Борис", Gender.Male, 
//         LocalDate.of(1980, 2, 15), tree.getByName("Анна")));

//         tree.add(new Human ("Арина", Gender.Female, 
//         LocalDate.of(2010, 3, 30),
//         tree.getByName("Анна"), tree.getByName("Борис")));

//         tree.add(new Human ("Глеб", Gender.Male, 
//         LocalDate.of(2015, 4, 21),
//         tree.getByName("Анна"), tree.getByName("Борис")));

//         tree.add(new Human ("Нина", Gender.Female, 
//         LocalDate.of(1975, 5, 7), tree.getByName("Иван")));

//         tree.add(new Human ("Иван", Gender.Male, 
//         LocalDate.of(1970, 6, 28), tree.getByName("Нина")));

//         tree.add(new Human ("Ирина", Gender.Female, 
//         LocalDate.of(2000, 1, 1),
//         tree.getByName("Нина"), tree.getByName("Иван")));

//         tree.add(new Human("Михаил", Gender.Male, LocalDate.of(2022, 05, 10), 
//         tree.getByName("Анна"), tree.getByName("Борис")));


//         Human grandMother = new Human("Клавдия", Gender.Female, LocalDate.of(1950, 8, 15));
//         grandMother.addChild(tree.getByName("Нина"));
//         grandMother.addChild(tree.getByName("Анна"));
//         // grandMother.addSpouse(tree.getByName("Семен"));
//         tree.add(grandMother);

//         Human grandFother = new Human("Семен", Gender.Male, LocalDate.of(1947, 8, 19), 
//         tree.getByName("Клавдия"));
//         grandFother.addChild(tree.getByName("Нина"));
//         grandFother.addChild(tree.getByName("Анна"));
//         tree.add(grandFother);

//         return tree;
//         }
// }
