package main;

import java.io.*;

public class FileHandler implements Writable, Serializable {
    private String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileHandler() {
        this.filename = "tree.out";
    }

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.printf("FamilyTree save in %s\n", filename);
            oos.writeObject(serializable);
        } catch (Exception ex) {
            System.out.println("Ошибка сохранения");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        } catch (Exception ex) {
            System.out.println("Ошибка чтения");
            System.out.println(ex.getMessage());
        }
        return null;
    }

}