package model.work_with_file;

import model.family_tree.FamilyTree;
import model.work_with_file.interfaces.WriteInterface;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteToFile implements WriteInterface {
    private String path;

    public WriteToFile(String path) {
        this.path = path;
    }

    public void write(FamilyTree ft) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(ft);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
