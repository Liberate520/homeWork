package modell.file_handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modell.fam_tree.FamilyTree;
import modell.fam_tree.TreeNode;

public class FileHandler<E extends TreeNode<E>> implements SaveToFile<E> {
    private static String filePath = "homeWork_family_tree/output/human_data.ser";

    public boolean saveToFile(FamilyTree<E> tree) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(tree);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public FamilyTree<E> loadFromFile() {
        FamilyTree<E> tree = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Object object = inputStream.readObject();
            if (object instanceof FamilyTree<?>) {
                @SuppressWarnings("unchecked")
                FamilyTree<E> castedTree = (FamilyTree<E>) object;
                tree = castedTree;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tree;
    }
}
