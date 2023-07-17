package family_tree.Model.fileHandlers;

//import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
import java.io.IOException;
//import java.util.Scanner;

import family_tree.Model.familyTree.FamilyTree;
import family_tree.Model.human.Human;

public class FileHandlerForTree{

    public void saveTree(FamilyTree<Human> familyTree, boolean rewrite) throws IOException, ClassNotFoundException {
    //     FileWriter writer = new FileWriter("Projects_OOP/Projects_OOP_HomeWork/src/family_tree/FamilyTree.txt",
    //             rewrite);
    //     writer.write(familyTree.toTxt());
    //     writer.write("\n");
    //     writer.close();
    }

    public FamilyTree<Human> loadTree() throws FileNotFoundException, IOException, ClassNotFoundException {
         FamilyTree<Human> familyTree = new FamilyTree<Human>();
    //     Scanner scanner = new Scanner(new File("Projects_OOP/Projects_OOP_HomeWork/src/family_tree/FamilyTree.txt"));
    //     while (scanner.hasNextLine()) {
    //         String[] splitLine = scanner.nextLine().split(";");
    //         for (String string : splitLine) {
    //             Human human = new Human(string.split(" "), familyTree);
    //             familyTree.addHuman(human);
    //         }
    //     }
    //     familyTree.addChilrenForParentsName();
         return familyTree;
    }
}
