package file;

import java.io.*;

public class FileHandler implements Writable, Serializable {

    private String filename;

    public FileHandler() {
        this.filename = "backup";
    }

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.printf("календарь сохранен");
            write.writeObject(serializable);

        } catch (Exception ex) {
            System.out.println("Ошибка");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Object read() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(filename));
            return objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
