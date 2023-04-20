import java.io.*;

public class Serialization {
    private ObjectOutputStream file;
    private ObjectInputStream newFile;
    private FamilyTree family;

    public Serialization(ObjectOutputStream file, ObjectInputStream newFile, FamilyTree family) throws IOException {
        this.file = new ObjectOutputStream(new FileOutputStream("family.out"));
        this.newFile = new ObjectInputStream(new FileInputStream("family.out"));
        this.family = family;
    }

    public void save(FamilyTree family) throws IOException {
        file.writeObject(family);
        System.out.println("Объект сохранен");
        file.close();
    }

    public void readFile() throws IOException, ClassNotFoundException {
        family = (FamilyTree) newFile.readObject();
        newFile.close();
    }

}
