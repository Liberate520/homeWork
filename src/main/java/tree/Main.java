package tree;

import main.java.tree.FileHandler;
import main.java.tree.Writable;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/tree.txt";
        Writable writable = new FileHandler();
        //FamilyTree tree = (FamilyTree) writable.read(filePath);


        FamilyTree tree = new FamilyTree();

        ree.add(new Human("Иван", Gender.MaLe));
        tree.add(new Human("Марина", Gender.FemaLe));
        tree.add(new Human("Сергей",Gender.MaLe, tree.getByName("Марина"), tree.getByName("Иван")));
        tree.add(new Human("Светлана",Gender.FemaLe, tree.getByName("Марина"), tree.getByName("Иван")));
        tree.add(new Human("Наталья",Gender.FemaLe, tree.getByName("Марина"), tree.getByName("Иван")));

        writable.save(tree, filePath);

        System.out.println(tree.getInfo());
    }
}
