import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human father = new Human("Станислав", 1960, "male");
        Human human = new Human("Вася", father);
        Human human2 = new Human("Анна", human);
        Human human3 = new Human("Вася", human);

        System.out.println("Вывод humanов напрамую:");
        System.out.println(human3.toString());
        System.out.println(human2.toString());
        System.out.println(human.toString());
        System.out.println(father.toString());

        FamilyTree tree = new FamilyTree();
        tree.addHuman(new Human("Владимир", 1965, "male"));
        tree.addHuman(human);
        tree.addHuman(human2);
        tree.addHuman(human3);
        System.out.println();

        System.out.println("Вывод humanов через FamilyTree:");
        System.out.println(tree.findByName("Анна"));
        System.out.println();

        System.out.println("Вывод humanов через FamilyTree с одним именем:");
        System.out.println(tree.findAllByName("Вася"));
        System.out.println();
    }
}
