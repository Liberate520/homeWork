package familyTree.writer;

import familyTree.familyTree.FamilyTree;

import java.io.*;

public class FileHandler implements Writeable {
//    public static void serialization() throws IOException {
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"));
//        FamilyTree testTree = new FamilyTree();
//        oos.writeObject(testTree);
//        oos.close();
//    }

    @Override
    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.read();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
