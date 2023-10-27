package Files;

import tree.FamilyTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileHandler {
    public static void save(FamilyTree tree) throws IOException{
        FileOutputStream outputStream = new FileOutputStream("./Files/tree.tree");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }
    public static FamilyTree load() throws IOException, ClassNotFoundException{
        FileInputStream outputStream = new FileInputStream("./Files/tree.tree");
        ObjectInputStream objectOutputStream = new ObjectInputStream(outputStream);
        FamilyTree result = (FamilyTree) objectOutputStream.readObject();
        objectOutputStream.close();
        return result;
    }
}
