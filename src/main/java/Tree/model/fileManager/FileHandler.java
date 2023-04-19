package Tree.model.fileManager;

import java.io.*;

// класс для сериализации и десериализации дерева
public class FileHandler implements Writable {
    private final String path;

    // конструктор
    public FileHandler(String path) {
        this.path = path;
    }

    // метод записи в файл
    public void save(Serializable obj) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(path));
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("Ошибка записи в файл!");
        }
    }

    // метод для чтения из файла
    public Object load() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            Object obj = objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Данные загружены!");
            return obj;
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла!");
        }
        return null;
    }
}