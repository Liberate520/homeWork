package FT;
import java.io.*;
public class FileHandler implements Writable, Serializable {

    private String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileHandler() {
        this.filename = "familytree.dat";
    }

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.printf("Сохранено\n", filename);
            oos.writeObject(serializable);
        } catch (Exception ex) {
            System.out.println("Ошибка");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Tree read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Tree) ois.readObject();
        } catch (Exception ex) {
            System.out.println("Ошибка");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
