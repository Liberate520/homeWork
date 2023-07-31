package homeWork.family_tree;

import java.time.LocalDate;
import java.util.logging.FileHandler;

public class Main {
    public static void main(String[] args){
        String filePath = "file:///Users/mariannaizotova/Desktop/STUDY/OOProg/exportToHTML/homeWork/family_tree/data/test.out";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        System.out.println(tree);
    }
    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya.getId(), masha.getId());

        Human christina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5),
                vasya, masha);
        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25),
                vasya,masha);
        tree.add(christina);
        tree.add(semyon);

        Human larisa = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        larisa.addChild(vasya);
        tree.add(larisa);

        return tree;
    }
}
