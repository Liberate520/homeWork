import java.io.*;

public class SaveRestoreSerializable implements SaveAndLoad, Serializable{
    private final String pathToFile = System.getProperty("user.dir").
            concat(System.getProperty("file.separator"));
    private FamilyTree tree;

    public SaveRestoreSerializable(FamilyTree tree) {
        this.tree = tree;
    }

    public FamilyTree getTree() {
        return tree;
    }

    public void save (String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathToFile.concat(fileName)));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

    public void load (String fileName) throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathToFile.concat(fileName)));
        tree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
    }
}
