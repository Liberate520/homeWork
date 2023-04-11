import java.io.*;

public abstract class SaveRestore implements Serializable{
    private static final String pathToFile = System.getProperty("user.dir").
            concat(System.getProperty("file.separator"));

    public void saveTree (String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathToFile.concat(fileName)));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public static FamilyTree loadTree (String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathToFile.concat(fileName)));
        FamilyTree tree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }
}
