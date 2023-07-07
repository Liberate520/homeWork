package faminly_tree;

import java.io.IOException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        Human human1 = new Human("Darya", Gender.Female, LocalDate.of(1996, 10, 17));
        tree.addToTree(human1);
        Human human2 = new Human("Aleksey", Gender.Male, LocalDate.of(1967, 1, 03));
        tree.addToTree(human2);
        human1.childFor(human2);
        Human human3 = new Human("Elizaveta", Gender.Female, LocalDate.of(2000, 8, 10));
        tree.addToTree(human3);
        human3.childFor(human2);
        Human human4 = new Human("Elena", Gender.Female, LocalDate.of(1969, 12, 24));
        human1.childFor(human4);
        tree.addToTree(human4);
        Human human5 = new Human("Ivan", Gender.Male, LocalDate.of(2020, 5, 12));
        human5.childFor(human2);
        tree.addToTree(human5);
       // System.out.println(tree.nextOfKin(human1));
        SaveInFile sv = new SaveInFile();
        sv.write("tree.out", tree);
        System.out.println(sv.readTree("tree.out"));
        sv.write("human.out", human1);
        System.out.println(sv.readHuman("human.out"));
    }
}
