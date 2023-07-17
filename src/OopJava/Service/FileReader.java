package OopJava.Service;

import OopJava.Tree.FamilyTree;

import java.io.Serializable;
import java.io.*;

public class FileReader implements Serializable{
    public FamilyTree object;
    public void save(FamilyTree object) throws IOException, ClassNotFoundException {
        this.object = object;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Tree.out"));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        System.out.println("Файл сохранен");
    }
    public FamilyTree open() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Tree.out"));
        this.object = (FamilyTree) objectInputStream.readObject();
        System.out.println("Файл открыт");
        objectInputStream.close();
        return this.object;
    }
}

