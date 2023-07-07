package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import interfaces.Loadable;
import interfaces.Reading;
import genTree.GenTree;
import human.Human;

public class Loader implements Reading {
    @Override
    public Loadable loadObj(String path) throws ClassNotFoundException, IOException {
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