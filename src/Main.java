import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath="src/family_tree/tree.out";
 //       FileHandler fileHandler=new FileHandler();

//        FamilyTree tree = testTree();
//        System.out.println(tree);
//
//        fileHandler.save(tree,filePath);
//
        FileHandler fileHandler =new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        System.out.println(tree);
    }

    static  FamilyTree testTree(){
        FamilyTree tree =new FamilyTree();
        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963,12,10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965,9,15));
        tree.add (vasya);
        tree.add (masha);
        tree.setWedding(vasya.getId(),masha.getId());

        Human chritina =new Human("Кристина", Gender.Female, LocalDate.of(1988,7,5), vasya, masha);
        Human semyon =new Human("Семен", Gender.Male, LocalDate.of(1991,1,25), vasya, masha);
        tree.add(chritina);
        tree.add(semyon);

        Human larisa =new Human("Лариса", Gender.Female, LocalDate.of(1945,9,1));
        larisa.addChild(vasya);
        tree.add(larisa);

        return tree;
    }
}
