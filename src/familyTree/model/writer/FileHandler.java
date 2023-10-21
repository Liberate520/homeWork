package familyTree.model.writer;

import familyTree.model.familyTree.FamilyTree;
import familyTree.model.human.Human;

import java.io.*;

public class FileHandler implements Writeable {
    @Override
    public void save(Serializable serializable, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream
                (new FileOutputStream(filePath))) {
            oos.writeObject(serializable);
            System.out.println("Succesfully writed: " + filePath);
        } catch (Exception e) {
            System.out.println("Error by reading" + e.getMessage());
//            e.printStackTrace();
        }
    }

    @Override
    public Serializable read(String filePath) {
        Serializable output = null;
        try (ObjectInputStream ois = new ObjectInputStream
                (new FileInputStream(filePath))) {
            System.out.println("Succesfully rode: " + filePath);
            output = (Serializable) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error by reading file: " + e.getMessage());
//            e.printStackTrace();
        }
        return output;

    }
}
