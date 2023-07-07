package FamilyTree;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addHuman(new Human("Василий", Gender.Male, LocalDate.of(1958, 11, 7)));
        tree.addHuman(new Human("Людмила", Gender.Female, LocalDate.of(1958, 12, 8)));
        tree.addHuman(new Human("Андрей", Gender.Male, LocalDate.of(1992, 12, 1), tree.getHumanByName("Василий"), tree.getHumanByName("Людмила")));
        System.out.println(tree.getInfo());
    }
}