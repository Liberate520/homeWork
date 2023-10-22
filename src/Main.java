import my_family_tree.human.Gender;
import my_family_tree.human.Human;
import my_family_tree.tree.familyTree;
import my_family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

//        familyTree tree = load();
        familyTree tree = new familyTree();

        Human katya = new Human("Екатерина", Gender.Female, LocalDate.of(1986, 8, 16));
        Human kolya = new Human("Николай", Gender.Male, LocalDate.of(1984, 5, 9));
        tree.addToTheTree(katya);
        tree.addToTheTree(kolya);
        tree.weddind(katya, kolya);

        Human sasha = new Human("Александр", Gender.Male, LocalDate.of(2007, 1, 30),  katya, kolya);
        tree.addToTheTree(sasha);

        Human anya = new Human("Анна", Gender.Female, LocalDate.of(2010, 3, 7), katya, kolya);
        tree.addToTheTree(anya);

        System.out.println(tree.toString());
        System.out.println(tree.findSiblings(3));

//        save(tree);


    }

    private static void save(familyTree tree){
        String filePath = "src/my_family_tree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }

    private static familyTree load(){
        String filePath = "src/my_family_tree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        familyTree tree = (familyTree) fileHandler.read(filePath);
        return tree;

    }
}
