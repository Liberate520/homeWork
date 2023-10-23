import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Writable{
    private FamilyTree familyTree;

    public FileHandler(FamilyTree familyTree){
        this.familyTree = familyTree;
    }

    public void output() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("family_tree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    public FamilyTree input() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("family_tree.out"));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}
