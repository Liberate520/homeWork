package ru.gb.writable;

import ru.gb.node.FamilyTree;

import java.io.*;
import java.util.List;

public class FileHandlerForTree implements Writable {
    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("trees.out"));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public List<FamilyTree> loadFamilyTree() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("trees.out"));
        List<FamilyTree> treeLoaded = (List<FamilyTree>) objectInputStream.readObject();
        objectInputStream.close();
        return treeLoaded;
    }

}