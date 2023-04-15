import family.FamilyTree;
import humans.Gender;
import humans.Human;
import service.FileHandler;

import java.io.IOException;

public class Main {
    public static void main(
            String[] args) throws IOException, ClassNotFoundException {
        Human kolya = new Human("Kolya", "Black", Gender.Male, 31, 3, 1998);
        Human marina = new Human("Marina", "Black", Gender.Female, 1, 6, 1977);
        Human uriy = new Human("Uriy", "Black", marina, kolya, Gender.Male, 5,
                               12, 1969);
        Human john = new Human("John", "Black", Gender.Male, 8, 6, 1998);

        marina.addChild(john);
        john.addParent(kolya);
        FamilyTree tree_1 = new FamilyTree();
        tree_1.add(kolya);
        tree_1.add(john);
        tree_1.add(uriy);
        System.out.println(tree_1.getInfo());
        FileHandler fh = new FileHandler();
        tree_1.save(fh, "tree_1!_out.txt");
        FamilyTree treeRestore = fh.read("tree_1!_out.txt");
        System.out.println(treeRestore.getInfo());
    }
}
