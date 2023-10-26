package family_Tree;

import family_Tree.familyTree.FamilyTree;
import family_Tree.human.Gender;
import family_Tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = generateTree();
        System.out.println(tree);
    }

    static FamilyTree generateTree(){
        FamilyTree tree = new FamilyTree();
        Human Elena = new Human("Елена", LocalDate.of(1963,1,27), Gender.Female);
        tree.addHuman(Elena);
        Human Oleg = new Human("Олег", LocalDate.of(1968,4,9),Gender.Male);
        tree.addHuman(Oleg);
        Human Dima = new Human("Дмитрий", LocalDate.of(1985,5,29), Gender.Male, Oleg, Elena);
        tree.addHuman(Dima);
        Human Rita = new Human("Маргарита", LocalDate.of(1985,10,13), Gender.Female);
        tree.addHuman(Rita);
        Elena.addChild(Dima);
        Human Olesya = new Human("Олеся", LocalDate.of(1988,9,8), Gender.Female);
        Olesya.addParent(Oleg);
        Olesya.addParent(Elena);
        tree.addHuman(Olesya);

        return tree;
    }
}
