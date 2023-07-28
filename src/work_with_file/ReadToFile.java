package work_with_file;

import family_tree.FamilyTree;
import work_with_file.interfaces.ReadInterface;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

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
