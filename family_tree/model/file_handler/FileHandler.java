package family_tree.model.file_handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import family_tree.model.human_family.FamilyTree;
import family_tree.model.human_family.HumanItem;


public class FileHandler {
    public static <T extends HumanItem> void saveToFile(FamilyTree tree, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(tree);
            System.out.println("Дерево успешно сохранено в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FamilyTree loadFromFile(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (FamilyTree) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
