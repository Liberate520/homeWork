import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();
        tree.add(new Human("Павел", Sex.Male));
        tree.add(new Human("Александр", Sex.Male));
        tree.add(new Human("Олеся", Sex.Female));
        tree.add(new Human("Лейла", Sex.Female));
        tree.add(new Human("Вечислав", Sex.Male, tree.getByFirstname("Павел"), tree.getByFirstname("Лейла")));

        System.out.println(tree.getInfo());
    }
}
