import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
    private FamilyTree tree;

    public FamilyTree getTree() {
        return tree;
    }

    public FileHandler(FamilyTree tree) {
        this.tree = tree;
    }

    public void write (FamilyTree tree) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("tree.out"));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();

    }

    public Object read() throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("tree.out"));
        FamilyTree treeRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("После восстановления: " + "\n" + treeRestored.getInfo());
        return treeRestored;
    }
}
