import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class GenealogyTree implements Serializable{
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

    public static void saveToFile(GenealogyTree humans) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(humans);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static GenealogyTree loadFromFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        GenealogyTree tree = (GenealogyTree) ois.readObject();
        ois.close();
        return tree;
    }
}