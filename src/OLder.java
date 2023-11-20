import model.human.Gender;
import model.human.Human;
import model.writer.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class OLder {
    //FamilyTree tree = testTree();
    FamilyTree tree = load();
        System.out.println(tree);
    //System.out.println(tree.getInfo());
    //save(tree);
}

    public static FamilyTree load() {
        String filePath = "./tree.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        return tree;
    }

    private static void save(FamilyTree tree) {
        String filePath = "./tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }

    static FamilyTree ImportTree() {
        FamilyTree tree = new FamilyTree();
        String file;
        String[] word;
        String filename = "./Family_Tree_In.txt";
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                file = sc.nextLine();
                word = file.split(",");
                for (int i = 0; i < word.length; i++) {
                    word[i] = word[i].trim();
                }
                int human_ID = Integer.parseInt(word[0], 10);
                int first_parent_ID;
                if (!word[1].isEmpty()) first_parent_ID = Integer.parseInt(word[1], 10);
                else first_parent_ID = -1;
                LocalDate ld = LocalDate.parse(word[3]);
                Gender gen = Gender.valueOf(word[4]);
                Human name = new Human(human_ID, first_parent_ID, word[2], ld, gen, word[5]);
                tree.addHuman(name);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        tree.addFirstParent();
//        System.out.println(tree.getInfo());
        return tree;
    }
}
