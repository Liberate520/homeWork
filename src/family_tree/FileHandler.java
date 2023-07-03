package family_tree;

import java.io.*;

public class FileHandler implements Serializable{
    public void save(Object obj, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(obj);
            System.out.println("Семейное дерево сохранено в файл !: " + fileName + "utf-8" + "\n");
        } catch (IOException e) {
            System.err.println("Ошибка сохранения дерева: " + e.getMessage());
        }
    }
    public Object load(String fileName) {
        Object obj = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            obj = objectInputStream.readObject();
            System.out.println("Семейное дерево загружено из файла !: " + fileName + "\n");
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Ошибка загрузки дерева: " + e.getMessage());
        }
        return obj;
    }
}
