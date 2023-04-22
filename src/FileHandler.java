import java.io.*;

public class FileHandler implements SaveRead {
    private static FileHandler fileHandler;

    public void saveFile(FamilyTree object, String str) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(str));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }


    public FamilyTree loadFile(String str) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(str));
        FamilyTree object = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }
}