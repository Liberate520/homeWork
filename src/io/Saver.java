package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import interfaces.Saveable;
import interfaces.Writing;

public class Saver implements Writing {
    @Override
    public void writeObj(Saveable obj, String pathName) throws IOException {
        pathName = pathName + obj.getFileExt();
        ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(pathName));
        objOutStream.writeObject(obj);
        objOutStream.close();
    }
}