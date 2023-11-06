package FamilyTree;

import java.time.LocalDate;
import java.util.Scanner;

import FamilyTree.KindOfAnimal.Gender;
import FamilyTree.KindOfAnimal.Human;
import FamilyTree.family_tree.FamilyTree;
import FamilyTree.family_tree.FamilyTreeItem;
import FamilyTree.writer.FileHandler;



public class Main<T extends FamilyTreeItem> {

    // public void startPrint(){
    //         System.out.println("********************************MENU********************************");
    //         System.out.println("*                                                                  *");
    //         System.out.println("*                         Выберите действие                        *");
    //         System.out.println("*                            Варианты:                             *");
    //         System.out.println("*                 1 - Распечатать тестовое древо                   *");
    //         System.out.println("*                 2 - Отсортировать древо по Имени                 *");
    //         System.out.println("*                 3 - Отсортировать древо по дате рождения         *");
    //         System.out.println("*                 4 -                                              *");
    //         System.out.println("*                 5 -                                              *");
    //         System.out.println("*                 6 -                                              *");
    //         System.out.println("*                 0 - Выход                                        *");
    //         System.out.println("********************************************************************");
    // }
    //     public void start() {
    //     Scanner scanner = new Scanner(System.in);
        
    //     startPrint();
    //     while (true) {
    //         int command = scanner.nextInt();
    //         if (command == 0) break;
    //         else if (command == 1){
    //             FamilyTree tree = testTree();
    //             System.out. println(tree);
                
    //         }
    //          else if (command == 2){
    //             FamilyTree tree = testTree();
    //             tree.sortByBirthDate();
    //             System.out.println(tree.getInfo());
    //         }
    //         else if (command == 3){
    //             FamilyTree tree = testTree();
    //             tree.sortByBirthDate();
    //             System.out.println(tree.getInfo());
    //         }
    //         else if (command == 4){

    //         }
    //         else if (command == 5){

    //         }
    //         else if (command == 6){
                
    //         }
    //     }
    // }

    

    public static void main(String[] args) {
        



        //FamilyTree tree = testTree();
        // FamilyTree tree = load();
        //System.out. println(tree);
        //save(tree);

        // tree.sortByName(); // Сортировка по имени
        // System.out.println(tree.getInfo());

        // tree.sortByBirthDate();
        // System.out.println(tree.getInfo());

    }

    private static FamilyTree load() {
        String filePath = "/Users/prosto/Desktop/OOP/oop_hw/src/FamilyTree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        return tree;
    }
    private static void save (FamilyTree tree) {
        String filePath = "/Users/prosto/Desktop/OOP/oop_hw/src/FamilyTree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }

    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human mihail = new Human("Михаил",Gender.Male, LocalDate.of(1937, 8, 21), LocalDate.of(2012,11,13),  null, null);
        Human irina = new Human("Ирина",Gender.Female, LocalDate.of(1941, 3, 16), LocalDate.of(2019,2, 13), null, null);
        Human dmitriy= new Human("Дмитрий",Gender.Male, LocalDate.of(1930, 4, 10), LocalDate.of(2004,1,20), null, null);
        Human anastasiya = new Human("Анастасия",Gender.Female, LocalDate.of(1935, 3, 25), LocalDate.of(2009,2,13), null, null);
        tree.add(mihail);
        tree.add(irina);
        tree.add(dmitriy);
        tree.add(anastasiya);
        tree.setWedding(mihail,irina);
        tree.setWedding(dmitriy,anastasiya);

        Human michail=new Human("Михаил",Gender.Male, LocalDate.of(1960,8,29), null,  irina, mihail);
        Human marina = new Human("Марина",Gender.Female, LocalDate.of(1970,8,29), null, irina, mihail);
        Human galina=new Human("Галина",Gender.Female, LocalDate.of(1956, 5, 9), null, anastasiya, dmitriy);
        Human nikolay=new Human("Николай",Gender.Male, LocalDate.of(1966,5,9), null, anastasiya, dmitriy);
        Human ivan =new Human("Иван",Gender.Male, LocalDate.of(1966,5,9), null, anastasiya, dmitriy);
        tree.add(michail);
        tree.add(marina);
        tree.add(galina);
        tree.add(nikolay);
        tree.add(ivan);
        tree.setWedding(ivan,marina);

        Human anna=new Human("Анна",Gender.Female, LocalDate.of(1998,11,15), null, marina, ivan);
        Human dima =new Human("Дмитрий",Gender.Male, LocalDate.of(2005,9,7), null, marina, ivan);
        Human vanya=new Human("Иван",Gender.Male, LocalDate.of(2011,11,23), null, marina, ivan);
        tree.add(anna);
        tree.add(dima);
        tree.add(vanya);

        return tree;

    }
}


