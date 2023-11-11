package HomeWork.familyTree.homeWork22_10_23.src.write;

import HomeWork.familyTree.homeWork22_10_23.src.tree.FamilyTree;

import java.io.*;

public class FileHandler {
    public void writeObject(Serializable serializable, String filePath)  {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(serializable);
            out.close();
            System.out.println("File to save");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Object readObject(String filePath) {


        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("File to read");
            return  (FamilyTree) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
