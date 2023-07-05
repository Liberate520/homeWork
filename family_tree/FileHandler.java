package family_tree;
import family_tree.Human;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FileHandler {
    public static void WriteFile(FamilyTree familyTree, String fileName) {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(fileName))) {
            write.writeObject(familyTree);
            System.out.println("Файл сохранён!");
        } catch (IOException e) {
            System.out.println("Не удалось сохранить файл, ошибка: " + e.getMessage());
        }
    }

    public static FamilyTree ReadFile(String fileName) {
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(fileName))) {
            FamilyTree familyTree = (FamilyTree) read.readObject();
            System.out.println("Дерево загружено");
            return familyTree;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Не удалось загрузить файл, ошибка: " + e.getMessage());
            return null;
        }
    }
    
}
