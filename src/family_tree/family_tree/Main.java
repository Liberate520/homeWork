package family_tree.family_tree;

import family_tree.family_tree.model.FamilyTree;
import family_tree.family_tree.model.Gender;
import family_tree.family_tree.model.human.Human;
import family_tree.family_tree.view.ConsoleUI;
import family_tree.family_tree.view.View;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
//    Scanner scanner = new Scanner(System.in); // обратить внимание !! ??

    public static void main(String[] args) {

        View view = new ConsoleUI();
        view.start();

        var tree = testTree();           // !
//        FamilyTree tree = load();
        System.out.println(tree);

        tree.getByName();
        System.out.println(tree);

        tree.getByAge();
        System.out.println(tree);

    }
//***    если нужен был бы Iterator ***
//    private static String getHumanListInfoIterator(FamilyTree familyList) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Список Human-ов через iterator:\n");
//        for (Human human : familyList) {
//            sb.append(human);
//            sb.append("\n");
//        }
//        return sb.toString();
//    }



    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12,10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya, masha); // определяем их супругами

        Human christina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5), vasya, masha);
        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25), vasya, masha);
        tree.add(christina);
        tree.add(semyon);

        Human larisa = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        larisa.addChild(vasya);

        tree.add(larisa);

        return tree;
    }

}
