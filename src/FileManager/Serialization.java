package FileManager;
import Tree.FamilyTree;
import java.io.*;


public class Serialization implements Serializable {
    public void saveToFile(String filename, FamilyTree familyTree) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
            objectOutputStream.writeObject(familyTree);
            objectOutputStream.close();
            System.out.println("Запись прошла успешно: " + filename); // если все ок.
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage()); // любое исключение.
        }
    }

    public FamilyTree loadFromFile(String filename) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            FamilyTree Starki = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Загрузка прошла успешно: " + filename); //аналогично
            return Starki;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки: " + e.getMessage()); // аналогично
            return null;
        }
    }
}
