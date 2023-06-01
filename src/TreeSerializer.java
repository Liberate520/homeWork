import java.io.*;

public class TreeSerializer implements Serializer{

    public void save(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
            System.out.println("Объект сохранен в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения файла: " + e.getMessage());
        }
    }

    public FamilyTree load(String fileName) {
        FamilyTree tree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            tree = (FamilyTree) ois.readObject();
            System.out.println("Объект загружен из файла: " + fileName);
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Ошибка загрузки из файла: " + e.getMessage());
        }
        return tree;
    }
}
