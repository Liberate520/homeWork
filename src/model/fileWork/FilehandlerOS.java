package fileWork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import group.Groupable;
import person.NodeTree;

public class FilehandlerOS<T extends NodeTree<T>> implements Writeable<T> {

    @Override
    public void SaveToFile(Groupable<T> groupList, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(groupList);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Groupable<T> LoadFromFile(String filename) {
        Groupable<T> groupList = null;
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            groupList = ((Groupable<T>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return groupList;
    }
}
