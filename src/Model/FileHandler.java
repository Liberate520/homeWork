package Seminars_OOP.HW_5.src.Model;

import java.io.*;

public class FileHandler implements Writable, Serializable {

    private String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileHandler() {
        this.filename = "Tree.dat";
    }

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.printf("Сохранен файл: ", filename);
            oos.writeObject(serializable);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public FamilyTree read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}