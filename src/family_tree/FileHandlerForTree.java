package family_tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlerForTree implements Writable {

    public void saveTree(FamilyTree familyTree, boolean rewrite) throws IOException, ClassNotFoundException {
        FileWriter writer = new FileWriter("Projects_OOP/Projects_OOP_HomeWork/src/family_tree/FamilyTree.txt",
                rewrite);
        writer.write(familyTree.toTxt());
        writer.write("\n");
        writer.close();
    }

    public FamilyTree loadTree() throws FileNotFoundException, IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        Scanner scanner = new Scanner(new File("Projects_OOP/Projects_OOP_HomeWork/src/family_tree/FamilyTree.txt"));
        while (scanner.hasNextLine()) {
            String[] splitLine = scanner.nextLine().split(";");
            for (String string : splitLine) {
                Human human = new Human(string.split(" "), familyTree);
                familyTree.addHuman(human);
            }
            familyTree.addChilrenForParentsName(familyTree);
        }
        return familyTree;
    }
}
