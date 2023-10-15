package familyTree;


import familyTree.model.familyTree.FamilyTree;
import familyTree.model.human.Gender;
import familyTree.model.human.Human;
import familyTree.model.writer.FileHandler;
import familyTree.view.ConsoleUI;

import java.io.IOException;
import java.time.LocalDate;

public class Main{
    public static void main(String[] args) throws IOException {
        String filePath = "src/familyTree/writer/testTree.txt";
        FileHandler fileHandler = new FileHandler();

        FamilyTree<Human> tree = testTree();
//        FamilyTree<Human> tree = (FamilyTree) fileHandler.read(filePath);
        System.out.println("Without sort: " + tree);
        tree.sortByName();

        fileHandler.save(tree, filePath);

        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }

    static FamilyTree<Human> testTree() throws IOException {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human dinara = new Human("Динара",
                LocalDate.of(1998, 1, 31),
                Gender.Female);
        Human slava = new Human("Вячеслав",
                LocalDate.of(1995, 8, 14),
                Gender.Male);
        tree.addToFamily(dinara);
        tree.addToFamily(slava);
        tree.setWedding(dinara, slava);

        Human anastasia = new Human("Анастасия", Gender.Female,
                LocalDate.of(2019, 3, 15), dinara, slava);
        Human stas = new Human("Станислав", Gender.Male, LocalDate.of(2024, 5, 27),
                dinara, slava);
        tree.addToFamily(anastasia);
        tree.addToFamily(stas);

        dinara.addChild(anastasia);
        slava.addChild(stas);

        Human nadezda = new Human("Надежда", LocalDate.of(1962, 3, 8), Gender.Female);
        nadezda.addChild(dinara);
        tree.addToFamily(nadezda);

        return tree;
    }


}
