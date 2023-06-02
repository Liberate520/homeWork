package files;
import java.io.*;

public class FileHandler implements Writable, Serializable {

    private String filename;

    //    в будущем в клиентском коде можно определять другой файл
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileHandler() {
//        имя файла по умолчанию. определяем в пустом конструкторе
        this.filename = "file.txt";
    }

    @Override
    public boolean save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filename))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }



}
