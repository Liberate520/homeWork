package FamilyTree;

import java.io.Serializable;
import java.io.*;

public class Reader implements Serializable{
    public Tree object;
    public void save(Tree object) throws IOException, ClassNotFoundException {
        this.object = object;
        ObjectOutputStream objectectOutputStream = new ObjectOutputStream(new FileOutputStream("Tree.out"));
        objectectOutputStream.writeObject(object);
        objectectOutputStream.close();
        System.out.println("Файл сохранен");
    }
    public Tree open() throws IOException, ClassNotFoundException {
        ObjectInputStream objectectInputStream = new ObjectInputStream(new FileInputStream("Tree.out"));
        this.object = (Tree) objectectInputStream.readObject();
        System.out.println("Файл открыт");
        objectectInputStream.close();
        return this.object;
    }
}