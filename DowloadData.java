package HW_3;

import java.io.*;

public class DowloadData implements InOut {
    public void save(FamilyTree family, String str) {

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(str));
            objectOutputStream.writeObject(family);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FamilyTree load(String str) {
        FamilyTree family = new FamilyTree();

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(str));
            family = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return family;
    }
}