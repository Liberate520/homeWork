package src.FamilyTree;

import java.io.*;

public class FileHandler implements RW{
    private final String path;

    public FileHandler() {
        this.path = "sFT.ser";
    }

    @Override
    public void write(Serializable obj) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(path));
            objectOutput.writeObject(obj);
            objectOutput.close();
            System.out.println("\nThe Family Tree is saved to sFT.ser\n");
        } catch (Exception e) {
            System.out.println("Could not save to file.");
        }
    }

    @Override
    public Object read() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            Object obj = objectInputStream.readObject();
            objectInputStream.close();
            return obj;
        } catch (Exception e) {
            System.out.println("Could not read from file");
        }
        return null;
    }
}
