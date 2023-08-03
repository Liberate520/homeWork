import java.util.ArrayList;
import java.util.Scanner;

public class Reserch {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;
    ArrayList<String> resultAge = new ArrayList<>();

    public Reserch(Family_Tree family_tree) {
        tree = family_tree.getTree();
    }

    public ArrayList<String> spend(Human h, Relationship rp) {
        for (Node t : tree) {
            if (t.h1.name.equals(h.name) && t.rp == rp) {
                result.add(t.h2.name);
            }
        }
        return result;
    }

    public ArrayList<String> searchAge() {
        System.out.print("Введите ограничение по возрасту: ");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        System.out.print("Люди, младше: " + age + ":");

        for (Node t : tree) {
            if (t.h1.age <= age && !resultAge.contains(t.h1.name)) {
                resultAge.add(t.h1.name);
            }
        }
        return resultAge;
    }
}
