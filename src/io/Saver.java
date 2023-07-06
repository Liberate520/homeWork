package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import interfaces.Saveable;

public class Saver {
    public void saveData(Saveable obj, String pathName) throws IOException {
        pathName = pathName + obj.getFileExt();
        ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(pathName));
        objOutStream.writeObject(obj);
        objOutStream.close();
    }
}