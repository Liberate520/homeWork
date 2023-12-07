package ru.gb.writable;

import ru.gb.node.FamilyTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerForTree implements Writable {
    private List<FamilyTree> familyTrees;
    public FileHandlerForTree(List<FamilyTree> familyTrees) throws IOException, ClassNotFoundException {
        this.familyTrees = familyTrees;
    }

    public FileHandlerForTree() throws IOException, ClassNotFoundException {
        this(new ArrayList<>());
    }

    @Override
    public void save() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("trees.out"));
        objectOutputStream.writeObject(familyTrees);
        objectOutputStream.close();
    }

    @Override
    public Serializable load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("trees.out"));
        Serializable treeLoaded = (Serializable) objectInputStream.readObject();
        objectInputStream.close();
        return treeLoaded;
    }

}