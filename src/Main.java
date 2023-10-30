import Tree.FamilyTree;
import Tree.FileHandler;
import Tree.Gender;
import Tree.Human;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = load();

        Human human  = new Human("John", Gender.male);
        Human parent1 = new Human("Sara", Gender.female);
        Human parent2 = new Human("Connor", Gender.male);
        Human grandma = new Human("Scarlett", Gender.female);

        tree.addHuman(human);
        tree.addHuman(parent1);
        tree.addHuman(parent2);
        tree.addHuman(grandma);

        tree.setParent1(human,parent1);
        tree.setParent2(human,parent2);

        tree.setParent1(parent1,grandma);

        tree.printTree();

        write(tree);
    }

    private static void write(FamilyTree familyTree) {
        String filepath = "homeWork\\src\\Text\\tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.write(familyTree, filepath);
    }

    private static FamilyTree load() {
        String filepath = "homeWork\\src\\Text\\tree.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree familyTree = (FamilyTree) fileHandler.read(filepath);
        return familyTree;
    }
}
