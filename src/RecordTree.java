import java.io.*;

public class RecordTree implements Writable{
    // Класс для сохранения и загрузки списка Person
    public void saveTree(FamilyTree tree,String path) {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(
                             new FileOutputStream(path))) {
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e);
        }
    }

    public Object loadTree(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path)
        )) {
            return objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Невозможно распознать объект: " + e);
        }
        return null;
    }
}
