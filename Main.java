package homeWork;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Family_tree familyTree = new Family_tree();
        /*Human mother = new Human(null,null,null,null,Gender.Female);
        Human father = new Human(null,null,null,null,Gender.Male);*/ //Не понял как подтянуть мазер фазер в виде хуманов, какое-то бесконечное дерево получается
        ArrayList<String> children = new ArrayList<>(); // Не понял как подтянуть чилдренов в виде хуманов.
        children.add("Petya");
        children.add("Vasya");
        Human h1 = new Human("Olga", "Oleg", children, LocalDate.of(1950, 5, 30), Gender.Male);
        familyTree.addHuman(h1);
        System.out.println(familyTree.getFamilyTree());
    }
}
