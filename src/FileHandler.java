import java.io.*;

public class FileHandler implements WritableFile, Serializable {
    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("family-tree.dat"))) {
            outputStream.writeObject(serializable);
            System.out.println("File saved ...");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public Family readFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("family-tree.dat"))) {
            return (Family) inputStream.readObject();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
