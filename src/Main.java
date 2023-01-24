import java.io.IOException;
import java.io.Serializable;


public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tree<Human> familyTree = new Tree<Human>();
        Human human1 = new Human("Igor", "Petrov", 1, 60, "male");
        Human human2 = new Human("Olga", "Petrova", 2, 59, "female");
        Human human3 = new Human("Geo", "Petrov", 20, 90, "male");
        Human human4 = new Human("Petr", "Petrov", 25, 2900, "male");

        familyTree.add_human(human1);
        familyTree.add_human(human2);
        familyTree.add_human(human3);
        familyTree.add_human(human4);
        
        // System.out.println(familyTree);
        // FileHandler fileHandler = new FileHandler();
        // fileHandler.save(familyTree.getHumanlist());
        // Tree<Human> tree = new Tree<Human>();
        // tree = fileHandler.read();
        // System.out.println();
        // System.out.println(tree);

        // System.out.println();

        // tree.sortByName();
        // for (Human human : tree) {
        //     System.out.println(human);
        // }
        // System.out.println();
        // tree.sortByBirth();
        // for (Human human : tree) {
        //     System.out.println(human);
        // }
        View view = new View();
        view.start();
        
    }

}
