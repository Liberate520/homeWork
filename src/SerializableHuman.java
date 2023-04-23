import java.io.*;

public class SerializableHuman implements Serializable {
    @Override
    public void save(Object obj, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(obj);
            System.out.println("Save: " + fileName);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public Object load(String fileName) {
        Object obj = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            obj = in.readObject();
            System.out.println("load: " + fileName);
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return obj;
    }
}
