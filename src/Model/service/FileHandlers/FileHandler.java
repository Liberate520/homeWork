package Model.service.FileHandlers;

import Model.FamilyTree;
import Model.units.Unit;

import java.io.*;

public class FileHandler<T extends Unit> implements Writable, Readable {
    @Override
    public void save(Object obj, String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree<T> read(
            String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        FamilyTree<T> treeRestore =
                (FamilyTree<T>) objectInputStream.readObject();
        objectInputStream.close();
        return treeRestore;
    }
}
