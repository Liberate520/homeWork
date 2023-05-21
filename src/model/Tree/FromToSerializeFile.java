package model.Tree;

import model.Elements.TreeElement;
import java.io.*;


public class FromToSerializeFile implements FromTo {
    private String fileName;

    public FromToSerializeFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public <E extends TreeElement> void saveTo(GenealogicalTree<E> family) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(family);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public GenealogicalTree readFrom(String fileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            return (GenealogicalTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
