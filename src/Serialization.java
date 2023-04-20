import java.io.*;

public class Serialization {
    private ObjectOutputStream file;
    private ObjectInputStream newFile;
    public FamilyTree newFamily;

    public Serialization(ObjectOutputStream file, ObjectInputStream newFile, FamilyTree newFamily) throws IOException {
        this.file = new ObjectOutputStream(new FileOutputStream("family.out"));
        this.newFile = new ObjectInputStream(new FileInputStream("family.out"));
        this.newFamily = newFamily;
    }

    public void save(FamilyTree oldFamily) throws IOException {
        file.writeObject(oldFamily);
        System.out.println("Объект сохранен");
        file.close();
    }

    public void readFile() throws IOException, ClassNotFoundException {
        newFamily = (FamilyTree) newFile.readObject();
        newFile.close();
    }

}
