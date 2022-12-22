import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human father = new Human("Станислав", 1960, "male");
        Human mother = new Human("Василиса", 1985, "female");
        Human humanM = new Human("Вася", 1995, "male");
        Human humanF = new Human("Екатерина", 2000, "female");
        Human human2 = new Human("Анна");

        // Human human3 = new Human("Вася", human);

        // System.out.println("Вывод humanов напрамую:");
        // System.out.println(human3.toString());
        // System.out.println(human2.toString());
        // System.out.println(human.toString());
        // System.out.println(father.toString());

        FamilyTree tree = new FamilyTree();
        tree.addHuman(new Human("Владимир", 1980, "male"), father, null);
        tree.addHuman(father, null, null);
        tree.addHuman(humanM, father, mother);
        tree.addHuman(human2, humanM, humanF);
        tree.addHuman(new Human("Анастасия"), null, human2);
        // tree.addAll(null);
        System.out.println();

        System.out.println("Вывод humanов через FamilyTree:");
        System.out.println(tree.findByName("Анна"));
        System.out.println();

        System.out.println("Вывод humanов через FamilyTree с одним именем:");
        System.out.println(tree.findAllByName("Вася"));
        System.out.println();

        System.out.println("Вывод humanов через FamilyTree с помощью метода showAllToConsole");
        tree.showAllInConsole();
        System.out.println();
    }
}
