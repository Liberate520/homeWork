package Family_Tree;

import Family_Tree.model.Tree.FamilyTree;
import Family_Tree.model.Human.Human;
import Family_Tree.model.Human.Gender;
import Family_Tree.model.Writer.FileHandler;
import Family_Tree.view.ConsoleUI;
import Family_Tree.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
//        FamilyTree tree = wholeTree();
////        FamilyTree tree=load();
//        System.out.println(tree);
//
//        save(tree);
//    }
//
//    private static FamilyTree load(){
//        FileHandler fileHandler=new FileHandler();
//        String filePath = "src/Family_Tree/writer/tree.txt";
//        return (FamilyTree) fileHandler.read(filePath);
//    }
//
//    private static void save(FamilyTree tree){
//        FileHandler fileHandler=new FileHandler();
//        String filePath = "src/Family_Tree/Writer/tree.txt";
//        fileHandler.save(tree, filePath);
//    }
//
//
//    static FamilyTree wholeTree(){
//        FamilyTree tree = new FamilyTree();
//
//        Human lev = new Human("Лев", LocalDate.of(1937, 8, 21), LocalDate.of(2012,11,13), Gender.Male, null, null);
//        Human iza = new Human("Изольда", LocalDate.of(1941, 3, 16), LocalDate.of(2019,2, 13),Gender.Female, null, null);
//        Human dmitriy= new Human("Дмитрий", LocalDate.of(1930, 4, 10), LocalDate.of(2004,1,20),Gender.Male, null, null);
//        Human anastasiya = new Human("Анастасия", LocalDate.of(1935, 3, 25), LocalDate.of(2009,2,13),Gender.Female, null, null);
//        tree.add(lev);
//        tree.add(iza);
//        tree.add(dmitriy);
//        tree.add(anastasiya);
//        tree.setWedding(lev,iza);
//        tree.setWedding(dmitriy,anastasiya);
//
//        Human michail=new Human("Михаил", LocalDate.of(1960,8,29), null, Gender.Male, iza, lev);
//        Human marina = new Human("Марина", LocalDate.of(1970,8,29), null,Gender.Female, iza, lev);
//        Human galina=new Human("Галина", LocalDate.of(1956, 5, 9), null,Gender.Female, anastasiya, dmitriy);
//        Human nikolay=new Human("Николай", LocalDate.of(1966,5,9), null,Gender.Male, anastasiya, dmitriy);
//        Human ivan =new Human("Иван", LocalDate.of(1966,5,9), null,Gender.Male, anastasiya, dmitriy);
//        tree.add(michail);
//        tree.add(marina);
//        tree.add(galina);
//        tree.add(nikolay);
//        tree.add(ivan);
//        tree.setWedding(ivan,marina);
//
//        Human anna=new Human("Анна", LocalDate.of(1998,11,15), null,Gender.Female, marina, ivan);
//        Human dima =new Human("Дмитрий", LocalDate.of(2005,9,7), null,Gender.Male, marina, ivan);
//        Human vanya=new Human("Иван", LocalDate.of(2011,11,23), null,Gender.Male, marina, ivan);
//        tree.add(anna);
//        tree.add(dima);
//        tree.add(vanya);
//
//        return tree;
//    }
}
