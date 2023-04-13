import java.io.*;


public class FromToSerializeFile {
    private String fileName;
    private GenealogicalTree family;

    public FromToSerializeFile(String fileName, GenealogicalTree family) {
        this.fileName = fileName;
        this.family = family;
    }

    public void saveTo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(family);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public GenealogicalTree readFrom(String fileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            GenealogicalTree result = (GenealogicalTree) ois.readObject();
            return result;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
