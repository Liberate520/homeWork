import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException {
        Trees familyTrees = new Trees();
        Human human1 = new Human("Igor", "Petrov", 1, 60, "male");
        Human human2 = new Human("Olga", "Petrova", 2, 59, "female");

        familyTrees.add_human(human1);
        familyTrees.add_human(human2);

        Human human3 = new Human("Geo", "Petrov", 20, 90, "male");
        Human human4 = new Human(human3, human1, human2);

        familyTrees.add_human(human4);

        System.out.println(familyTrees);
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTrees.getHumanlist());
        fileHandler.read(familyTrees.getHumanlist());
        System.out.println(familyTrees);
        System.out.println();
        
        for (Human human : familyTrees) {
            System.out.println(human);
        }
    }

}
