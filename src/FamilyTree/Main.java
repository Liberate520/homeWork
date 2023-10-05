package FamilyTree;

import FamilyTree.FamilyTree.FamilyTree;
import FamilyTree.human.Gender;
import FamilyTree.human.Human;

import java.time.LocalDate;

public class Main {
    // Добавлять людей и связи между ними.
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);
    }
    static  FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human andrey = new Human("andrey", Gender.Male, LocalDate.of(1983,10,1));
        Human masha = new Human("masha", Gender.Female, LocalDate.of(1987,1,19));
        tree.add(andrey);
        tree.add(masha);
        tree.setWedding(andrey, masha);

        Human david = new Human("david", Gender.Male, LocalDate.of(2017,8,22),andrey, masha);
        Human ilya = new Human("ilya", Gender.Male, LocalDate.of(2022,6,1),andrey, masha);
        tree.add(david);
        tree.add(ilya);

        Human elena = new Human("elena", Gender.Female, LocalDate.of(1960, 1, 23));
        elena.addChildren(andrey);
        tree.add(elena);

        return tree;
    }
}