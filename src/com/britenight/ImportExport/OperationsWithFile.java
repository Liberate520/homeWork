package com.britenight.ImportExport;

import com.britenight.FamilyTree.FamilyTree;

import java.io.*;

public final class OperationsWithFile<E extends Comparable<Object>> {
    public void saveToFile(FamilyTree<E> tree, String path) throws IOException {
        FileOutputStream f = new FileOutputStream(new File(path));
        ObjectOutputStream o = new ObjectOutputStream(f);

        o.writeObject(tree);

        o.close();
        f.close();
    }

    public FamilyTree<E> readFromFile(String path) throws ClassNotFoundException, IOException {
        FileInputStream fi = new FileInputStream(new File(path));
        ObjectInputStream oi = new ObjectInputStream(fi);

        FamilyTree<E> fmt = (FamilyTree<E>) oi.readObject();

        oi.close();
        fi.close();

        return fmt;
    }
}
