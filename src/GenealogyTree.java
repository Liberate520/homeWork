import java.util.ArrayList;
import java.util.List;

public class GenealogyTree {
    private static List<Human> humans = new ArrayList<>();

    public static List<Human> getHumans() {
        return humans;
    }

    public static void addHuman(Human human) {
        humans.add(human);
    }

    public static void printTree(String tab, Human human) {
        System.out.println(tab + human.toString());
        List<Human> children = human.getChildren();
        for (Human child : children) {
            printTree("   ", child); // КОСТЫЛЬ!!!
        }
    }
}