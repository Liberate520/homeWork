package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import interfaces.Loadable;
import interfaces.Reading;

public class Loader implements Reading {
    @Override
    public Loadable loadObj(String path) throws ClassNotFoundException, IOException {
        ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(path));
        Object restoredObj = objInStream.readObject();
        objInStream.close();
        if (restoredObj instanceof Loadable) {
            return (Loadable)restoredObj;
        }
        throw new ClassNotFoundException("file not Loadable");
    }
}