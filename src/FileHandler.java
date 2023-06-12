import java.io.*;

public class FileHandler implements Serializable {

    private String path;

    public FileHandler(String path) {
        this.path = path;
    }

    public void saveFile(Tree tree) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(tree);
        } catch (IOException e) {
            System.out.println("Export error");
        }
    }

    public Tree loadFile() {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ops = new ObjectInputStream(fis)) {
            return (Tree) ops.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Нет");
        }
        return null;
    }
}
