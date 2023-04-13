import java.io.*;


public class FromToSerializeFile implements FromTo {
    private String fileName;

    public FromToSerializeFile(String fileName) {
        this.fileName = fileName;
    }

    public void saveTo(GenealogicalTree family) {
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
