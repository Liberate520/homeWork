import java.io.*;

public class FileHandler implements Writable{
    private String path;

    public FileHandler(String path) {
        this.path = path;
    }

    public boolean saveFile(Serializable serializable) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(serializable);
            return true;
        } catch (IOException e) {
            System.out.println("Export error");
            return false;
        }
    }

    public Tree loadFile() {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ops = new ObjectInputStream(fis)) {
            return (Tree) ops.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
