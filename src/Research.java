import java.util.ArrayList;
import java.util.Scanner;

public class Research {
    private ArrayList<String> result = new ArrayList<>();
    private ArrayList<Node> tree;
    private ArrayList<String> resultAge = new ArrayList<>();

    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    // метод поиска связи
    public ArrayList<String> spend(Person p, Relation re) {
        for (Node t : tree) {
            if (t.getP1().getFullName() == p.getFullName() && t.getRe() == re) {
                result.add(t.getP2().getFullName());
            }
        }
        return result;
    }

    // метод поиска по возрасту
    public ArrayList<String> searchAge() {
        System.out.print("Введите ограничение по возрасту: ");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        System.out.println("Люди, младше: " + age + ":");

        for (Node t : tree) {

            if (t.getP1().getAge() <= age && !resultAge.contains(t.getP1().getFullName())) {
                resultAge.add(t.getP1().getFullName());
            }
        }
        return resultAge;
    }
}
