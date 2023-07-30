package Home_work;

import java.time.LocalDate;

import Home_work.Family_tree.Family_tree;
import Home_work.Gender.Gender;
import Home_work.Human.Human;
import Home_work.Writer.FileHendler;


public class Main {
    public static void main(String[] args) {
        String fileDB = "src/Family_tree/data/tree.out";

        FileHendler fileHendler = new FileHendler();
        Family_tree familyTree = testTree();
        System.out.println(familyTree);

        fileHendler.save(familyTree, fileDB);

    }

    static Family_tree testTree() {
        Family_tree familyTree = new Family_tree();

        Human human4 = new Human("John", Gender.Male, LocalDate.of(1945, 01, 9), LocalDate.of(2008, 07, 29));
        Human human1 = new Human("Irina", Gender.Female, LocalDate.of(1980, 11, 11), null, human4);
        Human human2 = new Human("Sergey", Gender.Male, LocalDate.of(1975, 04, 07), LocalDate.of(2010, 01, 01));
        Human human3 = new Human("Arina", Gender.Female, LocalDate.of(1999, 01, 01), human1, human2);

        familyTree.addTree(human1);
        familyTree.addTree(human2);
        familyTree.addTree(human3);
        familyTree.addTree(human4);

        return familyTree;
    }

}
