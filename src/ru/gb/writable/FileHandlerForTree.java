package ru.gb.writable;

import ru.gb.node.FamilyTree;
import ru.gb.node.TreeItem;

import java.io.*;
import java.util.List;

public class FileHandlerForTree<E extends TreeItem<E>> implements Writable {
    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("trees.out"));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public List<FamilyTree<E>> loadFamilyTree() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("trees.out"));
        List<FamilyTree<E>> treeLoaded = (List<FamilyTree<E>>) objectInputStream.readObject();
        objectInputStream.close();
        return treeLoaded;
    }

}