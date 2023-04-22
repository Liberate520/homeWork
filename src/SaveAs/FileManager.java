package SaveAs;
import FamalyTree.FamilyTree;

import java.io.*;

public class FileManager implements Savable{

    @Override
    public void save(FamilyTree familyTree, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(familyTree);
        } catch (Exception e) {
        }

    }

    @Override
    public FamilyTree upload(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (FamilyTree) objectInputStream.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
