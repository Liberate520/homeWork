import java.io.*;

public class FileHandler implements Writable, Serializable {
    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("family.dat"))) {
            oos.writeObject(serializable);
            System.out.println("Saved");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Family read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("family.dat"))) {
            return (Family) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
