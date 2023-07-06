package io;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import interfaces.Loadable;
import genTree.GenTree;
import genTree.Human;

public class Loader {
    public Loadable loadData(String path) throws ClassNotFoundException, IOException {
        ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(path));
        Object restoredObj = (Object)objInStream.readObject();
        objInStream.close();
        if (restoredObj instanceof GenTree) {
            return (GenTree)restoredObj;
        }
        if (restoredObj instanceof Human) {
            return (Human)restoredObj;
        }
        throw new ClassNotFoundException("file not support");
    }
}