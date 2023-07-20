package com.britenight.ImportExport;

import com.britenight.FamilyTree.FamilyTree;

import java.io.*;

public final class OperationsWithFile {
    public static void saveToFile(FamilyTree tree, String path) throws IOException {
        FileOutputStream f = new FileOutputStream(new File(path));
        ObjectOutputStream o = new ObjectOutputStream(f);

        o.writeObject(tree);

        o.close();
        f.close();
    }

    public static FamilyTree readFromFile(String path) throws ClassNotFoundException, IOException {
        FileInputStream fi = new FileInputStream(new File(path));
        ObjectInputStream oi = new ObjectInputStream(fi);

        FamilyTree fmt = (FamilyTree) oi.readObject();

        oi.close();
        fi.close();

        return fmt;
    }
}
