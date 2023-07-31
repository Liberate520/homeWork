package file_handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import fam_tree.FamilyTree;
import fam_tree.TreeNode;

public class FileHandler <E extends TreeNode<E>> {
     private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public void saveToFile(FamilyTree<E> tree) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(tree);
            System.out.println("Data saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FamilyTree<E> loadFromFile() {
        FamilyTree<E> tree = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            tree = (FamilyTree<E>) inputStream.readObject();
            System.out.println("Data loaded from file: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tree;
    }
}
