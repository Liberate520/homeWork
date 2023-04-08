package fileWorker.fileHandlers;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import familyTree.Tree;
import fileWorker.FileWorker;

public class FileHandler implements FileWorker {
    @Override
    public void save(Object object, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(object);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void readFromfile(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) 
        {
            Tree tree = (Tree) inputStream.readObject();
            System.out.println(tree.getTreeList());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
