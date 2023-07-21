package homeWork;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Family_tree familyTree = new Family_tree();
        /*Human mother = new Human(null,null,null,null,Gender.Female);
        Human father = new Human(null,null,null,null,Gender.Male);*/ //Не понял как подтянуть мазер фазер в виде хуманов, какое-то бесконечное дерево получается
        ArrayList<String> children = new ArrayList<>(); // Не понял как подтянуть чилдренов в виде хуманов.
        children.add("Petya");
        children.add("Vasya");
        Human h1 = new Human("Olga", "Oleg", children, LocalDate.of(1950, 5, 30), Gender.Male);
        familyTree.addHuman(h1);
        System.out.println(familyTree.getFamilyTree());
        FileHandler s1 = new FileHandler();
        s1.Save(h1);
        Human s2;
        s2 = (Human) s1.Load();
        System.out.println("Human h1 after serialize" + s2);
    }
}
