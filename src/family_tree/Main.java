package family_tree;

// import java.io.IOException;
import java.time.LocalDate;

import family_tree.familyTree.FamilyTree;
import family_tree.fileHandlers.FileHandler;
//import family_tree.fileHandlers.FileHandlerForTree;
import family_tree.human.Gender;
import family_tree.human.Human;

public class Main {
    public static void main(String[] args){
        Human human1 = new Human("Alex", LocalDate.of(1914, 7, 28), Gender.Male);
        Human human2 = new Human("Susan", LocalDate.of(1917, 3, 24), Gender.Female);
        Human human3 = new Human("Bob", LocalDate.of(1935, 3, 12), Gender.Male);
        human1.setDeathDate(LocalDate.of(1964, 3, 2));
        human2.setDeathDate(LocalDate.of(1964, 3, 2));
        FamilyTree familyTree = new FamilyTree();
        familyTree.createFamily(human1, human2, human3);
        // System.out.println(familyTree.getFamilyTree());

        Human human4 = new Human("Olga", LocalDate.of(1915, 12, 5), Gender.Female);
        Human human5 = new Human("Mathew", LocalDate.of(1913, 7, 30), Gender.Male);
        Human human6 = new Human("Mary", LocalDate.of(1938, 5, 12), Gender.Female);
        human4.setDeathDate(LocalDate.of(1964, 3, 2));
        human5.setDeathDate(LocalDate.of(1964, 3, 2));
        familyTree.createFamily(human4, human5, human6);
        // System.out.println(familyTree2.getFamilyTree());

        // Human human7 = new Human("Andrew", LocalDate.of(1958, 6, 13), Gender.Male);
        // familyTree.createFamily(human3, human6, human7);
        // System.out.println(familyTree3.getFamilyTree());

        // FileHandlerForTree fileHandlerForTree = new FileHandlerForTree();
        FamilyTree restoredFamilyTree = new FamilyTree();
        // try {
        //     fileHandlerForTree.saveTree(familyTree, false);
        // } catch (ClassNotFoundException e) {
        //     System.out.println("Ошибка: ClassNotFoundException!");
        // } catch (IOException e) {
        //     System.out.println("Ошибка: IOException!");
        // }
        // try {
        //     restoredFamilyTree = fileHandlerForTree.loadTree();
        // } catch (IOException e) {
        //     System.out.println("Ошибка: IOException!");
        // } catch (ClassNotFoundException e) {
        //     System.out.println("Ошибка: ClassNotFoundException!");
        // }
        // System.out.println(restoredFamilyTree.getFamilyTree());
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, "Projects_OOP/Projects_OOP_HomeWork/src/family_tree/FamilyTree1.out");
        restoredFamilyTree = (FamilyTree) fileHandler.read("Projects_OOP/Projects_OOP_HomeWork/src/family_tree/FamilyTree1.out");
        System.out.println(restoredFamilyTree.getFamilyTree());
        restoredFamilyTree.sortByName();
        System.out.println("Sort by Name:");
        System.out.println(restoredFamilyTree.getFamilyTree());
        restoredFamilyTree.sortByBirthDate();
        System.out.println("Sort by BirthDate:");
        System.out.println(restoredFamilyTree.getFamilyTree());
        restoredFamilyTree.sortByAge();
        System.out.println("Sort by Age:");
        System.out.println(restoredFamilyTree.getFamilyTree());
    }
}
