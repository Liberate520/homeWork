package family_tree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlerForTree implements Writable {

    public void SaveTree(FamilyTree familyTree, boolean rewrite) throws IOException, ClassNotFoundException {
        FileWriter writer = new FileWriter("Projects_OOP/Projects_OOP_HomeWork/src/family_tree/FamilyTree.txt",
                rewrite);
        writer.write("-----------------------------------------------------------------\n");
        writer.write(familyTree.getFamilyTree());
        writer.write("\n");
        writer.close();
    }

    public void LoadTree() throws FileNotFoundException, IOException {
        FileReader reader = new FileReader("Projects_OOP/Projects_OOP_HomeWork/src/family_tree/FamilyTree.txt");
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
        reader.close();
    }
}
