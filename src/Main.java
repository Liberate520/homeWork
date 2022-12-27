import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException {
        Trees familyTrees = new Trees();
        Human human1 = new Human("Igor", "Petrov", 1, 60, "male");
        Human human2 = new Human("Olga", "Petrova", 2, 59, "female");
        Human human3 = new Human("Geo", "Petrov", 20, 90, "male");
        Human human4 = new Human("Petr", "Petrov", 25, 2900, "male");

        familyTrees.add_human(human1);
        familyTrees.add_human(human2);
        familyTrees.add_human(human3);
        familyTrees.add_human(human4);

        System.out.println(familyTrees);
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTrees.getHumanlist());
        fileHandler.read(familyTrees.getHumanlist());
        System.out.println(familyTrees);
        System.out.println();

        familyTrees.SortByName();
        for (Human human : familyTrees) {
            System.out.println(human);
        }
        System.out.println();
        familyTrees.SortByBirth();
        for (Human human : familyTrees) {
            System.out.println(human);
        }
    }

}
