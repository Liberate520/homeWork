package home_work_class;

import java.io.*;
import java.util.List;

public class FileWriter implements Writeable{
    private String path;

    public FileWriter(String path) {
        this.path = path;
    }
    public FileWriter() {
        this("tree.out");
    }
    public void write(FamilyTree tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.path));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

    public FamilyTree read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.path));
        FamilyTree tree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();

        return tree;
    }
}
