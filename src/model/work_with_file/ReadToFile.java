package model.work_with_file;

import model.family_tree.FamilyTree;
import model.work_with_file.interfaces.ReadInterface;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadToFile implements ReadInterface {
    private String path;

    public ReadToFile(String path) {
        this.path = path;
    }

    public FamilyTree read() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            return (FamilyTree) objectInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
