package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/family_tree/data/tree.out";
        FileHandler fileHandler = new FileHandler();

        FamilyTree tree = testTree();
        //System.out.println(tree);

        fileHandler.save(tree,filePath);

        FileHandler fileHandler1 = new FileHandler();
        FamilyTree tree1 = (FamilyTree) fileHandler1.read(filePath);

        for(Human item:tree){
            System.out.println(item);
        }
        System.out.println();

        tree.sortByName();
        System.out.println(tree);

        tree.sortByAge();
        System.out.println(tree);
    }
    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();
        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963,12,10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1963,9,15));
        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya.getId(),masha.getId());

        Human christina = new Human("Кристина",Gender.Female,LocalDate.of(1988,7,5),
                vasya, masha);
        Human semyon = new Human("Семен",Gender.Male,LocalDate.of(1988,7,5),
                vasya,masha);
        tree.add(christina);
        tree.add(semyon);
        Human larisa = new Human("Лариса",Gender.Female,LocalDate.of(1945,9,1));
        larisa.addChild(vasya);
        tree.add(larisa);
        return tree;

    }
}
